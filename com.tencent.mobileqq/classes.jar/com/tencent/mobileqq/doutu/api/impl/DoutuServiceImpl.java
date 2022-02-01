package com.tencent.mobileqq.doutu.api.impl;

import android.os.Build.VERSION;
import android.os.HandlerThread;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.doutu.DoutuData;
import com.tencent.mobileqq.doutu.DoutuEmotionAdapter;
import com.tencent.mobileqq.doutu.DoutuEmotionHorizonListView;
import com.tencent.mobileqq.doutu.DoutuItem;
import com.tencent.mobileqq.doutu.DoutuMsgItem;
import com.tencent.mobileqq.doutu.DoutuReportData;
import com.tencent.mobileqq.doutu.DoutuReportData.Data;
import com.tencent.mobileqq.doutu.DoutuServlet;
import com.tencent.mobileqq.doutu.DuiButtonImageView;
import com.tencent.mobileqq.doutu.IDoutuListener;
import com.tencent.mobileqq.doutu.api.IDoutuSPUtil;
import com.tencent.mobileqq.doutu.api.IDoutuService;
import com.tencent.mobileqq.doutu.api.IDoutuUtils;
import com.tencent.mobileqq.doutu.combo.ComboObject;
import com.tencent.mobileqq.doutu.combo.ComboUIManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.profilecard.api.IProfileDataService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.singleupdate.MD5FileUtil;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.doutu.DoutuData;>;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import mqq.util.WeakReference;
import org.json.JSONObject;

public class DoutuServiceImpl
  implements IDoutuService
{
  private static final long COMBO_DURATION_DEFAULT = 15L;
  private static final long COMBO_KEEP_TIME_DEFAULT = 15L;
  private static final boolean COMBO_SWITCH_DEFAULT = false;
  private static final long DOUTU_KEEP_TIME_DEFAULT = 1800L;
  private static final long DOUTU_LAYOUT_SHOW_TIME = 5000L;
  public static final String DOUTU_RES_DOWNLOAD_REPORT_TAG = "doutuResDownload";
  private static final String DOUTU_RES_INFO_FILE_NAME = "doutuResInfo";
  private static final boolean DOUTU_SWITCH_DEFAULT = false;
  private static final long DUI_DURATION_DEFAULT = 15L;
  private static final int DUI_TIMES_DEFAULT = 3;
  private static final long MIN_TIME_SPACE = 1000L;
  private static final int RECOMMEND_COUNT_LIMIT = 1;
  private static final String REPORT_DOUTU_RECOMMEND_EXPOSE = "0X800B549";
  private static final int STATUS_GETTING_DOUTU = 1;
  private static final int STATUS_GETTING_DOUTU_IDEL = 0;
  private static final String TAG = "DoutuServiceImpl";
  private static final boolean TIMING_SWITCH = true;
  public static volatile boolean isLoadingRes = false;
  private ConcurrentHashMap<String, ConcurrentHashMap<String, DoutuServiceImpl.ComboMsgStamp>> aioComboMap = new ConcurrentHashMap();
  private ConcurrentHashMap<String, ConcurrentHashMap<String, DoutuServiceImpl.DoutuMsgStamp>> aioMap = new ConcurrentHashMap();
  private WeakReference<DoutuItem> catchDoutuItem;
  private long comboDuration = 15L;
  private long comboKeepTime = 15L;
  private boolean comboShowSwitch = true;
  private boolean comboSwitch = false;
  public List<String> dataMd5List = new ArrayList();
  public int defaultCount = 4;
  private long doutuKeepTime = 1800L;
  private List<DoutuData> doutuListPreload = new ArrayList();
  private List<DoutuData> doutuListShowing = new ArrayList();
  private boolean doutuSettingSwitch = true;
  private boolean doutuSwitch = false;
  private long duiDuration = 15L;
  private int duiTimes = 3;
  private EntityManager em;
  private boolean hasReadConfigFromSP = false;
  public boolean isSmartSwitchNew = false;
  private List<DoutuMsgItem> lastDoutuList;
  private volatile int lastDoutuListSize;
  private volatile int lastReportComboIndex = 0;
  private volatile int lastReportDuiIndex = 0;
  private long lastTimeStamp = 0L;
  private QBaseActivity mActity;
  private BaseQQAppInterface mApp;
  public ComboUIManager mComboUIManager = null;
  public RelativeLayout mContentView;
  public DoutuEmotionAdapter mDoutuAdapter;
  public MqqHandler mDoutuAnimationHandler;
  private HandlerThread mDoutuAnimationThread = ThreadManager.newFreeHandlerThread("DoutuServiceImpl", 0);
  public LinearLayout mDoutuLayout;
  private boolean mHasInited;
  public IDoutuListener mListener;
  private String mTroopUin;
  private String mUin;
  private String mUinType;
  public ConcurrentHashMap<Long, DoutuItem> requestCountMap = new ConcurrentHashMap();
  private volatile int status = 0;
  
  public DoutuServiceImpl()
  {
    this.mDoutuAnimationThread.start();
    this.mDoutuAnimationHandler = new MqqHandler(this.mDoutuAnimationThread.getLooper());
  }
  
  private int checkCombo(List<DoutuMsgItem> paramList, String paramString1, String paramString2, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkCombo ，startIndex = ");
      localStringBuilder.append(paramInt);
      QLog.d("DoutuServiceImpl", 2, localStringBuilder.toString());
    }
    int i = paramInt;
    int j = 0;
    while (i <= paramList.size() - this.duiTimes)
    {
      if (paramList.size() - paramInt < this.duiTimes) {
        return j;
      }
      int k = i;
      long l1;
      while (k < this.duiTimes + i - 1)
      {
        l1 = ((DoutuMsgItem)paramList.get(k)).a;
        k += 1;
        long l2 = ((DoutuMsgItem)paramList.get(k)).a;
        if ((l1 <= 0L) || (l2 <= 0L) || (l2 - l1 > this.comboDuration))
        {
          m = 0;
          break label177;
        }
      }
      int m = 1;
      label177:
      k = i;
      if (m != 0)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkCombo hit ，i = ");
          localStringBuilder.append(i);
          QLog.d("DoutuServiceImpl", 2, localStringBuilder.toString());
        }
        k = 3;
        recordComboStamp(paramString1, paramString2, (DoutuMsgItem)paramList.get(this.duiTimes + i - 1), 3, i);
        if (this.duiTimes + i == paramList.size()) {
          return 3;
        }
        m = this.duiTimes;
        j = i;
        m += i;
        i = k;
        k = m;
        while (k < paramList.size())
        {
          l1 = ((DoutuMsgItem)paramList.get(k)).a;
          m = k - 1;
          if (l1 - ((DoutuMsgItem)paramList.get(m)).a > this.comboKeepTime)
          {
            removeComboStamp(paramString1, paramString2);
            k = m;
            j = 0;
            break label424;
          }
          i += 1;
          recordComboStamp(paramString1, paramString2, (DoutuMsgItem)paramList.get(k), i, j);
          k += 1;
          j = m;
        }
        k = j;
        j = i;
      }
      label424:
      i = k + 1;
    }
    return j;
  }
  
  private int checkDui(List<DoutuMsgItem> paramList, String paramString1, String paramString2, int paramInt)
  {
    int i = paramList.size();
    int j = this.duiTimes;
    int m = -1;
    if (i - paramInt < j) {
      return -1;
    }
    i = paramList.size() - 1;
    while (i >= paramInt + this.duiTimes - 1)
    {
      j = i;
      for (;;)
      {
        k = this.duiTimes;
        int n = 0;
        if (j <= i - k + 1) {
          break;
        }
        long l1 = ((DoutuMsgItem)paramList.get(j - 1)).a;
        long l2 = ((DoutuMsgItem)paramList.get(j)).a;
        k = n;
        if (l1 <= 0L) {
          break label166;
        }
        k = n;
        if (l2 <= 0L) {
          break label166;
        }
        if (l2 - l1 > this.duiDuration)
        {
          k = n;
          break label166;
        }
        j -= 1;
      }
      int k = 1;
      label166:
      if (k != 0)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("checkDui hit，i = ");
          localStringBuilder.append(i);
          QLog.d("DoutuServiceImpl", 2, localStringBuilder.toString());
        }
        ReportController.b(this.mApp, "dc00898", "", "", "0X8007FA7", "0X8007FA7", 0, 0, "", "", "", "");
        recordDoutuStamp(paramString1, paramString2, (DoutuMsgItem)paramList.get(i));
        paramInt = m;
        if (!((DoutuMsgItem)paramList.get(i)).b) {
          paramInt = i;
        }
        if (i == paramList.size() - 1) {
          return paramInt;
        }
        j = i + 1;
        i = paramInt;
        paramInt = j;
        while (paramInt < paramList.size())
        {
          if (((DoutuMsgItem)paramList.get(paramInt)).a - ((DoutuMsgItem)paramList.get(paramInt - 1)).a > this.doutuKeepTime) {
            return i;
          }
          recordDoutuStamp(paramString1, paramString2, (DoutuMsgItem)paramList.get(paramInt));
          if (!((DoutuMsgItem)paramList.get(paramInt)).b) {
            i = paramInt;
          }
          paramInt += 1;
        }
        return i;
      }
      i -= 1;
    }
    return -1;
  }
  
  private boolean checkTime(List<DoutuMsgItem> paramList, int paramInt)
  {
    if (((DoutuMsgItem)paramList.get(paramInt)).a <= 0L)
    {
      if (QLog.isColorLevel()) {
        QLog.e("DoutuServiceImpl", 2, "handleCombo : doutuList.get(i).time <= 0");
      }
      return true;
    }
    return false;
  }
  
  private void dropPersistDoutuData()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuServiceImpl", 2, "dropPersistDoutuData ");
    }
    ThreadManager.excute(new DoutuServiceImpl.9(this), 32, null, false);
  }
  
  private DoutuEmotionHorizonListView getDoutuEmotionHorizonListView(MqqHandler paramMqqHandler, DoutuItem paramDoutuItem, int paramInt)
  {
    Object localObject = (LinearLayout)this.mContentView.findViewById(2131432077);
    if (localObject != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuServiceImpl", 2, "showDoutuEmotionLayout : doutuLayout != null.");
      }
      this.mDoutuLayout = ((LinearLayout)localObject);
      localObject = (DoutuEmotionHorizonListView)this.mDoutuLayout.findViewById(2131432080);
      this.mDoutuAdapter = ((DoutuEmotionAdapter)((DoutuEmotionHorizonListView)localObject).getAdapter());
      if (this.mDoutuAdapter == null)
      {
        this.mDoutuAdapter = new DoutuEmotionAdapter(this.mApp, this.mActity, this.mListener, this.mUin, this.mUinType, this.mTroopUin, paramMqqHandler, this.isSmartSwitchNew, paramDoutuItem, this.defaultCount);
        ((DoutuEmotionHorizonListView)localObject).setAdapter(this.mDoutuAdapter);
      }
      reportDoutuEventNew();
      return localObject;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoutuServiceImpl", 2, "showDoutuEmotionLayout : doutuLayout == null.");
    }
    this.mDoutuLayout = ((LinearLayout)View.inflate(this.mActity, 2131624087, null));
    localObject = (DoutuEmotionHorizonListView)this.mDoutuLayout.findViewById(2131432080);
    this.mDoutuAdapter = new DoutuEmotionAdapter(this.mApp, this.mActity, this.mListener, this.mUin, this.mUinType, this.mTroopUin, paramMqqHandler, this.isSmartSwitchNew, paramDoutuItem, this.defaultCount);
    ((DoutuEmotionHorizonListView)localObject).setAdapter(this.mDoutuAdapter);
    setListeners(paramMqqHandler, (DoutuEmotionHorizonListView)localObject);
    paramMqqHandler = new RelativeLayout.LayoutParams(-2, -2);
    paramMqqHandler.addRule(2, paramInt);
    paramMqqHandler.addRule(11);
    this.mContentView.addView(this.mDoutuLayout, paramMqqHandler);
    return localObject;
  }
  
  private String getFileMD5(String paramString)
  {
    try
    {
      str = getFileMD5String(paramString);
      paramString = str;
      if (str == null) {
        paramString = "";
      }
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      String str;
      label17:
      boolean bool;
      label54:
      label56:
      break label17;
    }
    finally
    {
      return "";
    }
    paramString = new File(paramString);
    bool = paramString.exists();
    if (bool) {}
    try
    {
      paramString = MD5FileUtil.a(paramString);
      if (paramString != null) {
        break label56;
      }
      paramString = "";
    }
    catch (IOException paramString)
    {
      break label54;
    }
    paramString = null;
    str = paramString;
    if (paramString == null) {
      str = "";
    }
    return str;
  }
  
  public static String getFileMD5String(String paramString)
  {
    Object localObject3 = null;
    Object localObject2;
    try
    {
      localObject4 = MD5.getPartfileMd5(paramString, 0L);
      Object localObject1 = localObject3;
      if (localObject4 != null) {
        localObject1 = MD5FileUtil.b((byte[])localObject4);
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      Object localObject4 = new StringBuilder();
      ((StringBuilder)localObject4).append("error ........ error getFileMD5String filePath: ");
      ((StringBuilder)localObject4).append(paramString);
      ((StringBuilder)localObject4).append(", error=");
      ((StringBuilder)localObject4).append(localException.getMessage());
      QLog.e("DoutuServiceImpl", 2, ((StringBuilder)localObject4).toString());
      localObject2 = localObject3;
    }
    if (QLog.isDebugVersion())
    {
      paramString = new StringBuilder();
      paramString.append("getFileMD5String md5: ");
      paramString.append(localObject2);
      QLog.e("DoutuServiceImpl", 2, paramString.toString());
    }
    return localObject2;
  }
  
  private void handleCombo(List<DoutuMsgItem> paramList, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleCombo, dirty = ");
      ((StringBuilder)localObject).append(Integer.toHexString(paramInt));
      QLog.d("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (!needHandleCombo(paramList, paramInt)) {
      return;
    }
    long l2 = getRecordComboTime(this.mUin, this.mUinType);
    paramInt = getRecordCombo(this.mUin, this.mUinType);
    long l3 = getRecordComboSeq(this.mUin, this.mUinType);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleCombo : recordComboTime = ");
      ((StringBuilder)localObject).append(l2);
      ((StringBuilder)localObject).append(", recordCombo = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", recordComboSeq = ");
      ((StringBuilder)localObject).append(l3);
      QLog.d("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleCombo : lastDoutuListSize = ");
      ((StringBuilder)localObject).append(this.lastDoutuListSize);
      ((StringBuilder)localObject).append(", doutuList.size() = ");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    boolean bool1 = false;
    int i;
    if (l2 > 0L)
    {
      i = paramInt;
      long l1 = l2;
      j = 0;
      paramInt = 0;
      bool1 = false;
      while (paramInt < paramList.size())
      {
        if (checkTime(paramList, paramInt)) {
          return;
        }
        localObject = new DoutuServiceImpl.ComboData(this, paramList, i, bool1, paramInt).e();
        if (((DoutuServiceImpl.ComboData)localObject).a()) {
          break label633;
        }
        i = ((DoutuServiceImpl.ComboData)localObject).b();
        bool1 = ((DoutuServiceImpl.ComboData)localObject).c();
        j = ((DoutuServiceImpl.ComboData)localObject).d();
        if (((DoutuMsgItem)paramList.get(paramInt)).a < l2) {
          l1 = ((DoutuMsgItem)paramList.get(paramInt)).a;
        }
        for (;;)
        {
          break;
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handleCombo : recordComboSeq = ");
            ((StringBuilder)localObject).append(l3);
            ((StringBuilder)localObject).append(", i = ");
            ((StringBuilder)localObject).append(paramInt);
            ((StringBuilder)localObject).append(", doutuList.get(i).shmsgseq = ");
            ((StringBuilder)localObject).append(((DoutuMsgItem)paramList.get(paramInt)).c);
            QLog.d("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
          }
          if ((((DoutuMsgItem)paramList.get(paramInt)).a == l2) && (l3 != 0L) && (((DoutuMsgItem)paramList.get(paramInt)).c != 0L) && (((DoutuMsgItem)paramList.get(paramInt)).c <= l3))
          {
            l1 = ((DoutuMsgItem)paramList.get(paramInt)).a;
          }
          else
          {
            if (((DoutuMsgItem)paramList.get(paramInt)).a - l1 > this.comboKeepTime)
            {
              removeComboStamp(this.mUin, this.mUinType);
              paramInt = j;
              i = 0;
              break label633;
            }
            i += 1;
            recordComboStamp(this.mUin, this.mUinType, (DoutuMsgItem)paramList.get(paramInt), i, paramInt);
            l1 = ((DoutuMsgItem)paramList.get(paramInt)).a;
          }
        }
        paramInt += 1;
      }
      paramInt = j;
      label633:
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleCombo(recordComboTime > 0) : combo = ");
        ((StringBuilder)localObject).append(i);
        QLog.d("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
      j = i;
      i = paramInt;
      paramInt = j;
    }
    else
    {
      i = 0;
    }
    int j = paramList.size();
    boolean bool2 = true;
    if (i < j - 1)
    {
      i = checkCombo(paramList, this.mUin, this.mUinType, i);
      paramInt = i;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleCombo : checkCombo = ");
        ((StringBuilder)localObject).append(i);
        QLog.d("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
        paramInt = i;
      }
    }
    Object localObject = (DoutuMsgItem)paramList.get(paramList.size() - 1);
    paramInt = handleTimeOut(paramInt, (DoutuMsgItem)localObject);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleCombo ： combo = ");
      localStringBuilder.append(paramInt);
      QLog.d("DoutuServiceImpl", 2, localStringBuilder.toString());
    }
    if ((this.lastDoutuListSize != 0) && (paramList.size() > this.lastDoutuListSize)) {
      bool1 = bool2;
    }
    if (paramInt > 0)
    {
      handleDownRes();
      reportCombo(paramList, paramInt);
    }
    handleComboUI(paramInt, bool1, (DoutuMsgItem)localObject);
    this.lastDoutuListSize = paramList.size();
    this.lastDoutuList = paramList;
  }
  
  private void handleComboUI(int paramInt, boolean paramBoolean, DoutuMsgItem paramDoutuMsgItem)
  {
    if (this.mComboUIManager != null)
    {
      long l = this.comboKeepTime - (NetConnInfoCenter.getServerTime() - paramDoutuMsgItem.a) + 1L;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("handleCombo ：delayTime = ");
        localStringBuilder.append(l);
        localStringBuilder.append(", NetConnInfoCenter.getServerTime() = ");
        localStringBuilder.append(NetConnInfoCenter.getServerTime());
        localStringBuilder.append(", lastMsg.time = ");
        localStringBuilder.append(paramDoutuMsgItem.a);
        QLog.d("DoutuServiceImpl", 2, localStringBuilder.toString());
      }
      if (paramInt == 0)
      {
        this.mComboUIManager.a(0L);
        return;
      }
      this.mComboUIManager.b();
      paramDoutuMsgItem = new ComboObject(paramDoutuMsgItem.k, paramInt - 2, paramBoolean);
      this.mComboUIManager.a(paramDoutuMsgItem);
      this.mComboUIManager.a(l * 1000L);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("DoutuServiceImpl", 2, "handleCombo: mComboUIManager is null");
    }
  }
  
  private void handleData()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoutuServiceImpl", 2, "showDoutuEmotionLayout : doutuListPreload.size() > 0.");
    }
    this.doutuListShowing.clear();
    this.dataMd5List.clear();
    moveDataToShowing();
    DoutuEmotionAdapter localDoutuEmotionAdapter = this.mDoutuAdapter;
    if (localDoutuEmotionAdapter != null)
    {
      localDoutuEmotionAdapter.c = new ArrayList();
      this.mDoutuAdapter.c.addAll(this.doutuListShowing);
    }
    this.doutuListPreload.clear();
    dropPersistDoutuData();
  }
  
  private void handleDownRes()
  {
    if (!DuiButtonImageView.b) {
      ThreadManager.post(new DoutuServiceImpl.7(this), 5, null, true);
    }
  }
  
  private int handleDui(List<DoutuMsgItem> paramList)
  {
    long l2 = getRecordDoutuTime(this.mUin, this.mUinType);
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleDui ：recordDoutuTime = ");
      ((StringBuilder)localObject).append(l2);
      QLog.d("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    int i;
    if (l2 > 0L)
    {
      long l1 = l2;
      i = 0;
      int k = -1;
      m = 0;
      for (;;)
      {
        j = k;
        if (i >= paramList.size()) {
          break;
        }
        if (((DoutuMsgItem)paramList.get(i)).a <= 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.e("DoutuServiceImpl", 2, "doutuList.get(i).time <= 0");
          }
          return -1;
        }
        if (((DoutuMsgItem)paramList.get(i)).a < l2)
        {
          l1 = ((DoutuMsgItem)paramList.get(i)).a;
        }
        else
        {
          if (((DoutuMsgItem)paramList.get(i)).a - l1 > this.doutuKeepTime)
          {
            j = -1;
            m = i;
            break;
          }
          recordDoutuStamp(this.mUin, this.mUinType, (DoutuMsgItem)paramList.get(i));
          long l3 = ((DoutuMsgItem)paramList.get(i)).a;
          l1 = l3;
          if (!((DoutuMsgItem)paramList.get(i)).b)
          {
            k = i;
            l1 = l3;
          }
        }
        m = i;
        i += 1;
      }
    }
    int j = -1;
    int m = 0;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleDui ：lastIndex = ");
      ((StringBuilder)localObject).append(m);
      QLog.d("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (m < paramList.size() - 1)
    {
      i = checkDui(paramList, this.mUin, this.mUinType, m);
      j = i;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleDui : checkResult = ");
        ((StringBuilder)localObject).append(i);
        QLog.d("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
        j = i;
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleDui ： duiIndex = ");
      ((StringBuilder)localObject).append(j);
      QLog.d("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (j >= 0)
    {
      if (j > paramList.size() - 1) {
        return -1;
      }
      localObject = (DoutuMsgItem)paramList.get(paramList.size() - 1);
      paramList = (DoutuMsgItem)paramList.get(j);
      paramList.l = true;
      if ((((DoutuMsgItem)localObject).a > 0L) && (NetConnInfoCenter.getServerTime() - ((DoutuMsgItem)localObject).a > this.doutuKeepTime))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleDui ：too long for doutuKeepTime ,set Dui false ! NetConnInfoCenter.getServerTime() = ");
          localStringBuilder.append(NetConnInfoCenter.getServerTime());
          localStringBuilder.append(", lastMsg.time = ");
          localStringBuilder.append(((DoutuMsgItem)localObject).a);
          QLog.d("DoutuServiceImpl", 2, localStringBuilder.toString());
        }
        paramList.l = false;
      }
      else
      {
        reportSendDoutuPic((DoutuMsgItem)localObject);
        if ((paramList.d) || (paramList.b))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("handleDui ： duiMsg.isFlowMessage = ");
            ((StringBuilder)localObject).append(paramList.d);
            ((StringBuilder)localObject).append(", duiMsg.isSend() = ");
            ((StringBuilder)localObject).append(paramList.b);
            QLog.d("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
          }
          paramList.l = false;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleDui ： duiMsg.isDui = ");
        ((StringBuilder)localObject).append(paramList.l);
        QLog.d("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
      if (paramList.l)
      {
        if (j != this.lastReportDuiIndex)
        {
          ReportController.b(this.mApp, "dc00898", "", "", "0X8008012", "0X8008012", 0, 0, "", "", "", "");
          this.lastReportDuiIndex = j;
        }
        handleDownRes();
        return j;
      }
    }
    return -1;
  }
  
  private int handleTimeOut(int paramInt, DoutuMsgItem paramDoutuMsgItem)
  {
    int i = paramInt;
    if (paramDoutuMsgItem.a > 0L)
    {
      i = paramInt;
      if (NetConnInfoCenter.getServerTime() - paramDoutuMsgItem.a > this.comboKeepTime)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("handleCombo ：too long for comboKeepTime ,set combo = 0 ! NetConnInfoCenter.getServerTime() = ");
          localStringBuilder.append(NetConnInfoCenter.getServerTime());
          localStringBuilder.append(", lastMsg.time = ");
          localStringBuilder.append(paramDoutuMsgItem.a);
          QLog.d("DoutuServiceImpl", 2, localStringBuilder.toString());
        }
        removeComboStamp(this.mUin, this.mUinType);
        i = 0;
      }
    }
    return i;
  }
  
  private boolean isComboOpen()
  {
    if (!this.hasReadConfigFromSP) {
      readFromSP();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isComboOpen : ");
      localStringBuilder.append(this.comboSwitch);
      localStringBuilder.append("isDoutuSettingOpen : ");
      localStringBuilder.append(this.doutuSettingSwitch);
      QLog.d("DoutuServiceImpl", 2, localStringBuilder.toString());
    }
    return (this.comboSwitch) && (this.doutuSettingSwitch) && (this.comboShowSwitch);
  }
  
  private void moveDataToShowing()
  {
    Iterator localIterator = this.doutuListPreload.iterator();
    while (localIterator.hasNext())
    {
      DoutuData localDoutuData = (DoutuData)localIterator.next();
      if (this.doutuListShowing.size() < 20)
      {
        this.doutuListShowing.add(localDoutuData);
        if (!TextUtils.isEmpty(localDoutuData.picMd5)) {
          this.dataMd5List.add(localDoutuData.picMd5);
        }
      }
    }
  }
  
  private boolean needHandleCombo(List<DoutuMsgItem> paramList, int paramInt)
  {
    paramInt &= 0xFFFF;
    if ((paramInt != 4) && (paramInt != 7) && (paramInt != 8)) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DoutuServiceImpl", 2, "handleCombo, no new msg");
    }
    this.lastDoutuListSize = paramList.size();
    this.lastDoutuList = paramList;
    return false;
  }
  
  private void persistDoutuData(List<DoutuData> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuServiceImpl", 2, "persistDoutuData ");
    }
    ThreadManager.excute(new DoutuServiceImpl.8(this, paramList), 32, null, false);
  }
  
  private void preLoad(DoutuItem paramDoutuItem, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("preLoad, isDoutuOpen() = ");
      localStringBuilder.append(isDoutuOpen());
      localStringBuilder.append(", doutuListPreload.size() = ");
      localStringBuilder.append(this.doutuListPreload.size());
      QLog.d("DoutuServiceImpl", 2, localStringBuilder.toString());
    }
    if ((isDoutuOpen()) && (this.doutuListPreload.size() == 0)) {
      postGetDoutuList(paramDoutuItem, paramString1, paramString2);
    }
  }
  
  private List<DoutuData> readDoutuDataFromDB()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuServiceImpl", 2, "readDoutuDataFromDB ");
    }
    EntityManager localEntityManager = this.em;
    if (localEntityManager != null) {
      return localEntityManager.query(DoutuData.class, true, null, null, null, null, null, null);
    }
    return null;
  }
  
  private void readFromSP()
  {
    if (this.mApp == null)
    {
      QLog.e("DoutuServiceImpl", 1, "readFromSP, mApp is null");
      return;
    }
    this.doutuSettingSwitch = ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).getDoutuSettingSwitch(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    this.doutuSwitch = ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).getDoutuSwitch(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    this.comboSwitch = ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).getDoutuComboSwitch(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    this.isSmartSwitchNew = ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).getDoutuSmartSwitchNew(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    long l1 = ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).getDoutuDuration(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    int i = ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).getDuiTimes(this.mApp.getApp(), this.mApp.getCurrentUin());
    long l2 = ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).getComboDuration(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    long l3 = ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).getComboKeep(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    int j = ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).getSmartPicCount(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    if (l1 > 0L) {
      this.duiDuration = l1;
    }
    if (i > 0) {
      this.duiTimes = i;
    }
    if (l2 > 0L) {
      this.comboDuration = l2;
    }
    if (l3 > 0L) {
      this.comboKeepTime = l3;
    }
    if (j > 0) {
      this.defaultCount = j;
    }
    this.hasReadConfigFromSP = true;
  }
  
  private void reportCombo(List<DoutuMsgItem> paramList, int paramInt)
  {
    if (paramList.size() - 1 != this.lastReportComboIndex)
    {
      ReportController.b(this.mApp, "dc00898", "", "", "0X8008095", "0X8008095", 0, 0, "", "", "", "");
      this.lastReportComboIndex = (paramList.size() - 1);
      if (paramInt == 3) {
        ReportController.b(this.mApp, "dc00898", "", "", "0X8008094", "0X8008094", 0, 0, "", "", "", "");
      }
    }
  }
  
  private void reportSendDoutuPic(DoutuMsgItem paramDoutuMsgItem)
  {
    if (paramDoutuMsgItem.b)
    {
      String str;
      if (paramDoutuMsgItem.e) {
        str = paramDoutuMsgItem.g;
      } else if (paramDoutuMsgItem.f) {
        str = paramDoutuMsgItem.h;
      } else {
        str = "";
      }
      ReportController.b(this.mApp, "dc00898", "", "", "0X800AF0B", "0X800AF0B", 0, 0, String.valueOf(paramDoutuMsgItem.i), "", str, "");
    }
  }
  
  private void setCardInfo(NewIntent paramNewIntent, String paramString)
  {
    paramString = ((IProfileDataService)this.mApp.getRuntimeService(IProfileDataService.class, "all")).getProfileCardFromCache(paramString);
    if (paramString != null)
    {
      paramNewIntent.putExtra("KEY_AGE", paramString.age);
      paramNewIntent.putExtra("key_gender", paramString.shGender);
      if (QLog.isColorLevel())
      {
        paramNewIntent = new StringBuilder();
        paramNewIntent.append("age = ");
        paramNewIntent.append(paramString.age);
        paramNewIntent.append(" , gender = ");
        paramNewIntent.append(paramString.shGender);
        QLog.d("DoutuServiceImpl", 2, paramNewIntent.toString());
      }
    }
  }
  
  private void setDoutuAdapter(MqqHandler paramMqqHandler, DoutuItem paramDoutuItem, DoutuEmotionHorizonListView paramDoutuEmotionHorizonListView)
  {
    this.mDoutuAdapter = new DoutuEmotionAdapter(this.mApp, this.mActity, this.mListener, this.mUin, this.mUinType, this.mTroopUin, paramMqqHandler, this.isSmartSwitchNew, paramDoutuItem, this.defaultCount);
    paramDoutuEmotionHorizonListView.setAdapter(this.mDoutuAdapter);
    if (this.doutuListPreload.size() > 0)
    {
      handleData();
    }
    else if (this.status == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuServiceImpl", 2, "showDoutuEmotionLayout : status == STATUS_GETTING_DOUTU_IDEL.");
      }
      this.doutuListShowing.clear();
      postGetDoutuList(paramDoutuItem, this.mUin, this.mUinType);
    }
    paramMqqHandler = this.mDoutuAdapter;
    if (paramMqqHandler != null)
    {
      paramMqqHandler.a();
      this.mDoutuAdapter.notifyDataSetChanged();
    }
  }
  
  private void setListeners(MqqHandler paramMqqHandler, DoutuEmotionHorizonListView paramDoutuEmotionHorizonListView)
  {
    paramDoutuEmotionHorizonListView.setOnScrollStateChangedListener(new DoutuServiceImpl.1(this));
    paramDoutuEmotionHorizonListView.setTouchListener(new DoutuServiceImpl.2(this, paramMqqHandler));
  }
  
  private void setRequestReportInfo(NewIntent paramNewIntent, String paramString1, String paramString2, DoutuItem paramDoutuItem)
  {
    if (Integer.valueOf(paramString2).intValue() == 0) {
      paramNewIntent.putExtra("KEY_SRC_UIN", Long.valueOf(this.mApp.getCurrentAccountUin()).longValue());
    } else {
      paramNewIntent.putExtra("KEY_SRC_UIN", Long.valueOf(paramString1));
    }
    int i = Integer.valueOf(paramString2).intValue();
    int j = 2;
    if (i == 0)
    {
      i = 1;
    }
    else
    {
      i = j;
      if (Integer.valueOf(paramString2).intValue() != 1)
      {
        Integer.valueOf(paramString2).intValue();
        i = j;
      }
    }
    paramNewIntent.putExtra("KEY_SESSION_TYPE", i);
    if (paramDoutuItem != null) {
      paramNewIntent.putExtra("KEY_TO_UIN", Long.valueOf(paramDoutuItem.e));
    }
  }
  
  private void unzip(String paramString)
  {
    Object localObject = IDoutuUtils.DOUTU_ANIMA_RES_PATH;
    try
    {
      FileUtils.uncompressZip(paramString, (String)localObject, false);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[unzip] success: ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuServiceImpl", 2, "[unzip]", paramString);
      }
    }
  }
  
  private boolean writeStringToFile(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (!paramString1.exists()) {}
    try
    {
      paramString1.createNewFile();
    }
    catch (IOException localIOException)
    {
      label24:
      boolean bool2;
      break label24;
    }
    bool2 = false;
    break label33;
    bool2 = true;
    try
    {
      label33:
      paramString1 = new FileOutputStream(paramString1, false);
    }
    catch (FileNotFoundException paramString1)
    {
      label46:
      boolean bool1;
      break label46;
    }
    paramString1 = null;
    bool2 = false;
    bool1 = bool2;
    if (paramString1 != null) {}
    try
    {
      paramString1.write(paramString2.getBytes());
      bool1 = bool2;
    }
    catch (IOException paramString2)
    {
      label72:
      break label72;
    }
    bool1 = false;
    bool2 = bool1;
    if (paramString1 != null) {}
    try
    {
      paramString1.flush();
      bool2 = bool1;
    }
    catch (IOException paramString2)
    {
      label91:
      break label91;
    }
    bool2 = false;
    bool1 = bool2;
    if (paramString1 != null) {}
    try
    {
      paramString1.close();
      return bool2;
    }
    catch (IOException paramString1)
    {
      label108:
      break label108;
    }
    bool1 = false;
    return bool1;
  }
  
  public void checkAndDownloadRes()
  {
    if (isLoadingRes)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuServiceImpl", 2, "checkAndDownloadRes : isLoadingRes = true");
      }
      return;
    }
    isLoadingRes = true;
    if ((!isDoutuOpen()) && (!isComboOpen()))
    {
      isLoadingRes = false;
      return;
    }
    if (this.mApp == null) {
      return;
    }
    String str1 = ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).getDoutuResMd5(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    String str2 = ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).getDoutuResUrl(this.mApp.getApp(), this.mApp.getCurrentAccountUin());
    Object localObject;
    if ((QLog.isColorLevel()) && (str1 != null) && (str2 != null))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("checkAndDownloadRes: md5 = ");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(", url = ");
      ((StringBuilder)localObject).append(str2);
      QLog.d("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if ((str1 != null) && (str1.length() != 0) && (str2 != null) && (str2.length() != 0))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(IDoutuUtils.DOUTU_ANIMA_RES_PATH);
      ((StringBuilder)localObject).append("DoutuRes.zip");
      localObject = ((StringBuilder)localObject).toString();
      if (!checkLocalResFiles(str1))
      {
        downloadRes(str2, (String)localObject, str1);
        return;
      }
      DuiButtonImageView.a();
      isLoadingRes = false;
      return;
    }
    isLoadingRes = false;
  }
  
  public boolean checkLocalResFiles()
  {
    return checkLocalResFiles(((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).getDoutuResMd5(this.mApp.getApp(), this.mApp.getCurrentAccountUin()));
  }
  
  public boolean checkLocalResFiles(String paramString)
  {
    Object localObject = new File(IDoutuUtils.DOUTU_ANIMA_RES_PATH);
    if (((File)localObject).exists())
    {
      if (!((File)localObject).isDirectory())
      {
        ((File)localObject).delete();
        return false;
      }
      if (((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).getDoutuResDamaged(this.mApp.getApp()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoutuServiceImpl", 2, "checkLocalResFiles : isDoutuResDamaged !");
        }
        FileUtils.delete(IDoutuUtils.DOUTU_ANIMA_RES_PATH, false);
        return false;
      }
      localObject = ((File)localObject).listFiles();
      if ((localObject != null) && (localObject.length != 0))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(IDoutuUtils.DOUTU_ANIMA_RES_PATH);
        ((StringBuilder)localObject).append("doutuResInfo");
        localObject = new File(((StringBuilder)localObject).toString());
        if ((((File)localObject).exists()) && (!((File)localObject).isDirectory()))
        {
          try
          {
            localObject = FileUtils.readFileToString((File)localObject);
            if ((QLog.isColorLevel()) && (paramString != null) && (localObject != null))
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("checkLocalResFiles: md5Record = ");
              localStringBuilder.append((String)localObject);
              localStringBuilder.append(", md5 = ");
              localStringBuilder.append(paramString);
              QLog.d("DoutuServiceImpl", 2, localStringBuilder.toString());
            }
            if ((localObject != null) && (paramString != null) && (((String)localObject).length() != 0) && (paramString.length() != 0)) {
              if (paramString.equals(localObject)) {
                break label285;
              }
            }
            FileUtils.delete(IDoutuUtils.DOUTU_ANIMA_RES_PATH, false);
            return false;
          }
          catch (IOException paramString)
          {
            paramString.printStackTrace();
            FileUtils.delete(IDoutuUtils.DOUTU_ANIMA_RES_PATH, false);
            return false;
          }
        }
        else
        {
          FileUtils.delete(IDoutuUtils.DOUTU_ANIMA_RES_PATH, false);
          return false;
        }
      }
      else
      {
        FileUtils.delete(IDoutuUtils.DOUTU_ANIMA_RES_PATH, false);
      }
    }
    else
    {
      return false;
    }
    label285:
    return true;
  }
  
  public void clearComboViews()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[ComboUIManager]clearComboViews, mComboUIManager == null : ");
      boolean bool;
      if (this.mComboUIManager == null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      QLog.i("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mComboUIManager;
    if (localObject != null) {
      ((ComboUIManager)localObject).c();
    }
  }
  
  public void doOnChatDestory()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuServiceImpl", 2, "doOnChatPieDestory");
    }
    hideDoutuEmotionLayout();
    removeDoutuEmoLayout();
    this.mContentView = null;
    this.mApp = null;
    this.mActity = null;
    this.lastReportDuiIndex = 0;
    this.lastDoutuListSize = 0;
    this.lastDoutuList = null;
    this.lastReportComboIndex = 0;
    this.mListener = null;
    ComboUIManager localComboUIManager = this.mComboUIManager;
    if (localComboUIManager != null)
    {
      localComboUIManager.a();
      this.mComboUIManager = null;
    }
    this.mHasInited = false;
  }
  
  public void doOnLogin(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doOnLogin, isFirstLogin = ");
      localStringBuilder.append(paramBoolean);
      QLog.i("DoutuServiceImpl", 2, localStringBuilder.toString());
    }
    initData();
    if ((NetworkUtil.isWifiEnabled(BaseApplication.getContext())) && (!paramBoolean)) {
      checkAndDownloadRes();
    }
  }
  
  public void downloadRes(String paramString1, String paramString2, String paramString3)
  {
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.mReqUrl = paramString1;
    localHttpNetReq.mHttpMethod = 0;
    localHttpNetReq.mOutPath = paramString2;
    localHttpNetReq.mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    localHttpNetReq.mCallback = new DoutuServiceImpl.10(this, paramString1, paramString2, paramString3);
    paramString2 = this.mApp;
    if (paramString2 == null) {
      return;
    }
    paramString2 = (IHttpEngineService)paramString2.getRuntimeService(IHttpEngineService.class, "all");
    if (paramString2 != null)
    {
      paramString2.sendReq(localHttpNetReq);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder();
        paramString2.append("downloadRes : [download] startDownload: ");
        paramString2.append(paramString1);
        paramString2.append(" path=");
        paramString2.append(localHttpNetReq.mOutPath);
        QLog.d("DoutuServiceImpl", 2, paramString2.toString());
      }
    }
  }
  
  public MqqHandler getDoutuAnimationHandler()
  {
    return this.mDoutuAnimationHandler;
  }
  
  public int getRecordCombo(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return 0;
      }
      if ((this.aioComboMap.get(paramString1) != null) && (((ConcurrentHashMap)this.aioComboMap.get(paramString1)).get(paramString2) != null)) {
        return ((DoutuServiceImpl.ComboMsgStamp)((ConcurrentHashMap)this.aioComboMap.get(paramString1)).get(paramString2)).d;
      }
    }
    return 0;
  }
  
  public int getRecordComboIndex(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return 0;
      }
      if ((this.aioComboMap.get(paramString1) != null) && (((ConcurrentHashMap)this.aioComboMap.get(paramString1)).get(paramString2) != null)) {
        return ((DoutuServiceImpl.ComboMsgStamp)((ConcurrentHashMap)this.aioComboMap.get(paramString1)).get(paramString2)).e;
      }
    }
    return 0;
  }
  
  public long getRecordComboSeq(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return 0L;
      }
      if ((this.aioComboMap.get(paramString1) != null) && (((ConcurrentHashMap)this.aioComboMap.get(paramString1)).get(paramString2) != null)) {
        return ((DoutuServiceImpl.ComboMsgStamp)((ConcurrentHashMap)this.aioComboMap.get(paramString1)).get(paramString2)).b;
      }
    }
    return 0L;
  }
  
  public long getRecordComboTime(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return 0L;
      }
      if ((this.aioComboMap.get(paramString1) != null) && (((ConcurrentHashMap)this.aioComboMap.get(paramString1)).get(paramString2) != null)) {
        return ((DoutuServiceImpl.ComboMsgStamp)((ConcurrentHashMap)this.aioComboMap.get(paramString1)).get(paramString2)).a;
      }
    }
    return 0L;
  }
  
  public long getRecordDoutuSeq(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return 0L;
      }
      if ((this.aioMap.get(paramString1) != null) && (((ConcurrentHashMap)this.aioMap.get(paramString1)).get(paramString2) != null)) {
        return ((DoutuServiceImpl.DoutuMsgStamp)((ConcurrentHashMap)this.aioMap.get(paramString1)).get(paramString2)).b;
      }
    }
    return 0L;
  }
  
  public long getRecordDoutuTime(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return 0L;
      }
      if ((this.aioMap.get(paramString1) != null) && (((ConcurrentHashMap)this.aioMap.get(paramString1)).get(paramString2) != null)) {
        return ((DoutuServiceImpl.DoutuMsgStamp)((ConcurrentHashMap)this.aioMap.get(paramString1)).get(paramString2)).a;
      }
    }
    return 0L;
  }
  
  public int handleAioMsgForDoutu(List<DoutuMsgItem> paramList, int paramInt)
  {
    int i;
    if (isDoutuOpen()) {
      i = handleDui(paramList);
    } else {
      i = -1;
    }
    if (isComboOpen()) {
      handleCombo(paramList, paramInt);
    }
    return i;
  }
  
  public void handleGetDoutuList(boolean paramBoolean, List<DoutuData> paramList)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleGetDoutuList : isSuccess = ");
        ((StringBuilder)localObject).append(paramBoolean);
        QLog.d("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
      if ((!paramBoolean) || (paramList == null) || (paramList.size() <= 0)) {
        break label447;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("handleGetDoutuList : dataList.size() = ");
        ((StringBuilder)localObject).append(paramList.size());
        QLog.d("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
      this.doutuListPreload.clear();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject = (DoutuData)paramList.next();
        this.doutuListPreload.add(localObject);
      }
      persistDoutuData(this.doutuListPreload);
      if ((this.mDoutuAdapter != null) && (this.doutuListShowing.size() == 0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DoutuServiceImpl", 2, "add data to doutuListShowing");
        }
        moveDataToShowing();
        this.mDoutuAdapter.c = new ArrayList();
        this.mDoutuAdapter.c.addAll(this.doutuListShowing);
        this.doutuListPreload.clear();
        dropPersistDoutuData();
        this.mDoutuAdapter.a();
        if (this.mDoutuAdapter.g != null) {
          this.mDoutuAdapter.g.sendEmptyMessage(81);
        }
      }
      if (this.doutuListPreload.size() <= 0) {
        break label447;
      }
      i = 0;
    }
    finally
    {
      for (;;)
      {
        Object localObject;
        int i;
        DoutuData localDoutuData;
        for (;;)
        {
          label447:
          throw paramList;
        }
        i += 1;
      }
    }
    if ((i < 9) && (i < this.doutuListPreload.size()))
    {
      localDoutuData = (DoutuData)this.doutuListPreload.get(i);
      if (localDoutuData != null)
      {
        try
        {
          localObject = localDoutuData.thumbDownUrl;
          paramList = (List<DoutuData>)localObject;
          if (((String)localObject).startsWith("https")) {
            paramList = ((String)localObject).replaceFirst("https", "http");
          }
          paramList = new URL(paramList);
        }
        catch (MalformedURLException paramList)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getView url exception e = ");
          ((StringBuilder)localObject).append(paramList.getMessage());
          QLog.e("DoutuServiceImpl", 1, ((StringBuilder)localObject).toString());
          paramList = null;
        }
        if (paramList != null)
        {
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = localDoutuData;
          URLDrawable.getDrawable(paramList, (URLDrawable.URLDrawableOptions)localObject).startDownload();
        }
      }
    }
    else
    {
      this.status = 0;
      return;
    }
  }
  
  public void handleGetRecommendPicList(boolean paramBoolean, List<DoutuData> paramList, long paramLong)
  {
    Object localObject;
    if (this.requestCountMap.get(Long.valueOf(paramLong)) != null)
    {
      localObject = (DoutuItem)this.requestCountMap.get(Long.valueOf(paramLong));
      ((DoutuItem)localObject).g += 1;
    }
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGetRecommendPicList isSuccess:");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(", key:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", type:, responseCount:");
      if (this.requestCountMap.get(Long.valueOf(paramLong)) != null) {
        i = ((DoutuItem)this.requestCountMap.get(Long.valueOf(paramLong))).g;
      } else {
        i = 0;
      }
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append(", size:");
      if (paramList == null) {
        i = 0;
      } else {
        i = paramList.size();
      }
      ((StringBuilder)localObject).append(i);
      QLog.i("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (paramList.size() > 0))
    {
      i = 0;
      while (i < paramList.size())
      {
        localObject = (DoutuData)paramList.get(i);
        if ((!TextUtils.isEmpty(((DoutuData)localObject).picMd5)) && (!this.dataMd5List.contains(((DoutuData)localObject).picMd5)))
        {
          localArrayList.add(localObject);
          this.dataMd5List.add(((DoutuData)localObject).picMd5);
        }
        i += 1;
      }
    }
    if (localArrayList.size() >= 0)
    {
      i = 0;
      while (i < localArrayList.size())
      {
        DoutuData localDoutuData = (DoutuData)localArrayList.get(i);
        if (localDoutuData != null)
        {
          try
          {
            localObject = localDoutuData.thumbDownUrl;
            paramList = (List<DoutuData>)localObject;
            if (((String)localObject).startsWith("https")) {
              paramList = ((String)localObject).replaceFirst("https", "http");
            }
            paramList = new URL(paramList);
          }
          catch (MalformedURLException paramList)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getView url exception e = ");
            ((StringBuilder)localObject).append(paramList.getMessage());
            QLog.e("DoutuServiceImpl", 1, ((StringBuilder)localObject).toString());
            paramList = null;
          }
          if (paramList != null)
          {
            localObject = URLDrawable.URLDrawableOptions.obtain();
            ((URLDrawable.URLDrawableOptions)localObject).mExtraInfo = localDoutuData;
            URLDrawable.getDrawable(paramList, (URLDrawable.URLDrawableOptions)localObject).startDownload();
          }
        }
        i += 1;
      }
    }
    boolean bool;
    if ((this.requestCountMap.get(Long.valueOf(paramLong)) != null) && (((DoutuItem)this.requestCountMap.get(Long.valueOf(paramLong))).g >= 1)) {
      bool = true;
    } else {
      bool = false;
    }
    paramList = this.mDoutuAdapter;
    if ((paramList != null) && (paramList.i == paramLong)) {
      ThreadManager.getUIHandler().post(new DoutuServiceImpl.5(this, paramBoolean, localArrayList, bool, paramLong));
    }
    if (bool) {
      this.requestCountMap.remove(Long.valueOf(paramLong));
    }
  }
  
  public void handleGetRecommendPicTimeOut(long paramLong)
  {
    Object localObject;
    if (this.requestCountMap.get(Long.valueOf(paramLong)) != null)
    {
      localObject = (DoutuItem)this.requestCountMap.get(Long.valueOf(paramLong));
      ((DoutuItem)localObject).g += 1;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGetRecommendPicTimeOut key:");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(", smartCount:");
      int i;
      if (this.requestCountMap.get(Long.valueOf(paramLong)) != null) {
        i = ((DoutuItem)this.requestCountMap.get(Long.valueOf(paramLong))).g;
      } else {
        i = 0;
      }
      ((StringBuilder)localObject).append(i);
      QLog.i("DoutuServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if ((this.requestCountMap.get(Long.valueOf(paramLong)) != null) && (((DoutuItem)this.requestCountMap.get(Long.valueOf(paramLong))).g >= 1))
    {
      this.requestCountMap.remove(Long.valueOf(paramLong));
      localObject = this.mDoutuAdapter;
      if ((localObject != null) && (((DoutuEmotionAdapter)localObject).i == paramLong)) {
        ThreadManager.getUIHandler().post(new DoutuServiceImpl.6(this, paramLong));
      }
    }
  }
  
  public boolean hasInited()
  {
    return this.mHasInited;
  }
  
  public void hideDoutuEmotionLayout()
  {
    if (this.mDoutuLayout != null)
    {
      reportDoutuEventNew();
      this.mDoutuLayout.setVisibility(8);
      Object localObject2 = null;
      this.mDoutuLayout = null;
      this.mDoutuAdapter = null;
      this.doutuListShowing.clear();
      this.dataMd5List.clear();
      WeakReference localWeakReference = this.catchDoutuItem;
      Object localObject1 = localObject2;
      if (localWeakReference != null)
      {
        localObject1 = localObject2;
        if (!localWeakReference.isEnqueued())
        {
          localObject1 = (DoutuItem)this.catchDoutuItem.get();
          this.catchDoutuItem = null;
        }
      }
      preLoad((DoutuItem)localObject1, this.mUin, this.mUinType);
    }
  }
  
  public void init(RelativeLayout paramRelativeLayout, BaseQQAppInterface paramBaseQQAppInterface, QBaseActivity paramQBaseActivity, IDoutuListener paramIDoutuListener, String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuServiceImpl", 2, "init");
    }
    this.mContentView = paramRelativeLayout;
    this.mApp = paramBaseQQAppInterface;
    this.mActity = paramQBaseActivity;
    this.mUin = paramString1;
    this.mUinType = paramString2;
    this.mTroopUin = paramString3;
    this.em = this.mApp.getEntityManagerFactory().createEntityManager();
    this.mListener = paramIDoutuListener;
    this.mComboUIManager = new ComboUIManager(paramBaseQQAppInterface, paramQBaseActivity, paramIDoutuListener, paramRelativeLayout);
    this.mHasInited = true;
  }
  
  public void initData()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("DoutuServiceImpl", 2, "initData ");
      }
      Object localObject1 = readDoutuDataFromDB();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        this.doutuListPreload.clear();
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          DoutuData localDoutuData = (DoutuData)((Iterator)localObject1).next();
          this.doutuListPreload.add(localDoutuData);
        }
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public void interruptAnimation()
  {
    ComboUIManager localComboUIManager = this.mComboUIManager;
    if (localComboUIManager != null) {
      localComboUIManager.d();
    }
  }
  
  public boolean isDoutuConfigOpen()
  {
    if (!this.hasReadConfigFromSP) {
      readFromSP();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDoutuConfigOpen : ");
      localStringBuilder.append(this.doutuSwitch);
      localStringBuilder.append(", isComboOpen : ");
      localStringBuilder.append(this.comboSwitch);
      QLog.d("DoutuServiceImpl", 2, localStringBuilder.toString());
    }
    return (this.doutuSwitch) || (this.comboSwitch);
  }
  
  public boolean isDoutuOpen()
  {
    if (!this.hasReadConfigFromSP) {
      readFromSP();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDoutuOpen : ");
      localStringBuilder.append(this.doutuSwitch);
      localStringBuilder.append(" ,isDoutuSettingOpen : ");
      localStringBuilder.append(this.doutuSettingSwitch);
      localStringBuilder.append(", duiDuration : ");
      localStringBuilder.append(this.duiDuration);
      localStringBuilder.append(", duiTimes :");
      localStringBuilder.append(this.duiTimes);
      QLog.d("DoutuServiceImpl", 2, localStringBuilder.toString());
    }
    return (this.doutuSwitch) && (this.doutuSettingSwitch);
  }
  
  public boolean isDoutuSettingOpen()
  {
    if (!this.hasReadConfigFromSP) {
      readFromSP();
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isDoutuSettingOpen : ");
      localStringBuilder.append(this.doutuSettingSwitch);
      QLog.d("DoutuServiceImpl", 2, localStringBuilder.toString());
    }
    return this.doutuSettingSwitch;
  }
  
  public void onCreate(AppRuntime paramAppRuntime) {}
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DoutuServiceImpl", 2, "onDestroy");
    }
    this.mDoutuLayout = null;
    this.mDoutuAdapter = null;
    try
    {
      if (this.mDoutuAnimationHandler != null) {
        this.mDoutuAnimationHandler.removeCallbacksAndMessages(null);
      }
      if (this.mDoutuAnimationThread != null) {
        this.mDoutuAnimationThread.quit();
      }
    }
    catch (Exception localException)
    {
      label55:
      ComboUIManager localComboUIManager;
      break label55;
    }
    this.mContentView = null;
    this.mApp = null;
    this.mActity = null;
    this.mDoutuAnimationThread = null;
    this.mDoutuAnimationHandler = null;
    this.mListener = null;
    localComboUIManager = this.mComboUIManager;
    if (localComboUIManager != null)
    {
      localComboUIManager.f();
      this.mComboUIManager = null;
    }
  }
  
  public void postGetDoutuList(DoutuItem paramDoutuItem, String paramString1, String paramString2)
  {
    ThreadManager.post(new DoutuServiceImpl.3(this, paramString1, paramString2, paramDoutuItem), 5, null, true);
  }
  
  public void postGetRecommendPicList(DoutuItem paramDoutuItem, String paramString1, String paramString2, long paramLong)
  {
    ThreadManager.post(new DoutuServiceImpl.4(this, paramDoutuItem, paramLong, paramString2, paramString1), 5, null, true);
  }
  
  public void recordComboStamp(String paramString1, String paramString2, DoutuMsgItem paramDoutuMsgItem, int paramInt1, int paramInt2)
  {
    long l1 = paramDoutuMsgItem.a;
    long l2 = paramDoutuMsgItem.c;
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return;
      }
      if (this.aioComboMap.get(paramString1) != null)
      {
        ((ConcurrentHashMap)this.aioComboMap.get(paramString1)).put(paramString2, new DoutuServiceImpl.ComboMsgStamp(this, l1, l2, paramDoutuMsgItem.k, paramInt1, paramInt2));
        return;
      }
      ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
      localConcurrentHashMap.put(paramString2, new DoutuServiceImpl.ComboMsgStamp(this, l1, l2, paramDoutuMsgItem.k, paramInt1, paramInt2));
      this.aioComboMap.put(paramString1, localConcurrentHashMap);
    }
  }
  
  public void recordDoutuStamp(String paramString1, String paramString2, DoutuMsgItem paramDoutuMsgItem)
  {
    if (paramDoutuMsgItem.b) {
      return;
    }
    long l1 = paramDoutuMsgItem.a;
    long l2 = paramDoutuMsgItem.c;
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return;
      }
      if (this.aioMap.get(paramString1) != null)
      {
        ((ConcurrentHashMap)this.aioMap.get(paramString1)).put(paramString2, new DoutuServiceImpl.DoutuMsgStamp(this, l1, l2));
        return;
      }
      paramDoutuMsgItem = new ConcurrentHashMap();
      paramDoutuMsgItem.put(paramString2, new DoutuServiceImpl.DoutuMsgStamp(this, l1, l2));
      this.aioMap.put(paramString1, paramDoutuMsgItem);
    }
  }
  
  public void refreshDoutuEmoData()
  {
    DoutuEmotionAdapter localDoutuEmotionAdapter = this.mDoutuAdapter;
    if (localDoutuEmotionAdapter != null) {
      localDoutuEmotionAdapter.notifyDataSetChanged();
    }
  }
  
  public void removeComboStamp(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString1.length() != 0) && (paramString2 != null))
    {
      if (paramString2.length() == 0) {
        return;
      }
      if (this.aioComboMap.get(paramString1) != null) {
        ((ConcurrentHashMap)this.aioComboMap.get(paramString1)).remove(paramString2);
      }
    }
  }
  
  public void removeDoutuEmoLayout()
  {
    LinearLayout localLinearLayout = this.mDoutuLayout;
    if (localLinearLayout != null)
    {
      RelativeLayout localRelativeLayout = this.mContentView;
      if (localRelativeLayout != null) {
        localRelativeLayout.removeView(localLinearLayout);
      }
    }
  }
  
  public void reportDoutuEventNew()
  {
    Object localObject1 = this.mDoutuAdapter;
    if (localObject1 == null) {
      return;
    }
    if ((((DoutuEmotionAdapter)localObject1).j == null) && (this.mDoutuAdapter.k == null)) {
      return;
    }
    localObject1 = new DoutuReportData();
    ((DoutuReportData)localObject1).a = "dc03631";
    localObject1.getClass();
    Object localObject2 = new DoutuReportData.Data((DoutuReportData)localObject1);
    ((DoutuReportData.Data)localObject2).a = String.valueOf(Long.valueOf(this.mApp.getCurrentAccountUin()).longValue());
    if (this.mDoutuAdapter.k != null)
    {
      ((DoutuReportData.Data)localObject2).f = this.mDoutuAdapter.k.picMd5;
      ((DoutuReportData.Data)localObject2).g = this.mDoutuAdapter.k.picDownUrl;
    }
    if (this.mDoutuAdapter.h != null)
    {
      ((DoutuReportData.Data)localObject2).c = this.mDoutuAdapter.h.d;
      ((DoutuReportData.Data)localObject2).b = this.mDoutuAdapter.h.b;
    }
    if ((this.mDoutuAdapter.j != null) && (this.mDoutuAdapter.j.size() > 0))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = this.mDoutuAdapter.j.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        localArrayList1.add(str);
        localArrayList2.add(this.mDoutuAdapter.j.get(str));
      }
      ((DoutuReportData.Data)localObject2).d = localArrayList1;
      ((DoutuReportData.Data)localObject2).e = localArrayList2;
    }
    if (this.mDoutuAdapter.e != null)
    {
      int i = Integer.valueOf(this.mDoutuAdapter.e).intValue();
      if (i == 0) {
        ((DoutuReportData.Data)localObject2).h = "c2c";
      } else if (i == 1) {
        ((DoutuReportData.Data)localObject2).h = "group";
      } else if (i == 3000) {
        ((DoutuReportData.Data)localObject2).h = "discuss";
      } else {
        ((DoutuReportData.Data)localObject2).h = "other";
      }
    }
    if (this.mDoutuAdapter.d != null) {
      ((DoutuReportData.Data)localObject2).j = this.mDoutuAdapter.d;
    }
    ((DoutuReportData.Data)localObject2).i = "android";
    ((DoutuReportData)localObject1).b = ((DoutuReportData.Data)localObject2);
    localObject2 = ((DoutuReportData)localObject1).a();
    localObject1 = new NewIntent(this.mApp.getApp(), DoutuServlet.class);
    ((NewIntent)localObject1).putExtra("KEY_CMD", 5);
    ((NewIntent)localObject1).putExtra("key_report_content", ((JSONObject)localObject2).toString());
    localObject2 = this.mDoutuAdapter;
    ((DoutuEmotionAdapter)localObject2).k = null;
    ((DoutuEmotionAdapter)localObject2).j = null;
    this.mApp.startServlet((NewIntent)localObject1);
  }
  
  public void setApp(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.mApp = paramBaseQQAppInterface;
  }
  
  public void setComboShowSwitch(boolean paramBoolean)
  {
    this.comboShowSwitch = paramBoolean;
  }
  
  public void showDoutuEmotionLayout(MqqHandler paramMqqHandler, DoutuItem paramDoutuItem, int paramInt)
  {
    for (;;)
    {
      try
      {
        if (this.mContentView == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DoutuServiceImpl", 2, "showDoutuEmotionLayout : parentView is null.");
          }
          return;
        }
        if (paramDoutuItem != null) {
          this.catchDoutuItem = new WeakReference(paramDoutuItem);
        }
        DoutuEmotionHorizonListView localDoutuEmotionHorizonListView = getDoutuEmotionHorizonListView(paramMqqHandler, paramDoutuItem, paramInt);
        if ((this.lastTimeStamp <= 0L) || (System.currentTimeMillis() - this.lastTimeStamp <= 0L) || (System.currentTimeMillis() - this.lastTimeStamp >= 1000L))
        {
          if (QLog.isColorLevel()) {
            QLog.d("DoutuServiceImpl", 2, "showDoutuEmotionLayout : not frequency click.");
          }
          setDoutuAdapter(paramMqqHandler, paramDoutuItem, localDoutuEmotionHorizonListView);
          this.lastTimeStamp = System.currentTimeMillis();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("showDoutuEmotionLayout isSmartSwitchNew:");
            localStringBuilder.append(this.isSmartSwitchNew);
            localStringBuilder.append(", defaultCount:");
            localStringBuilder.append(this.defaultCount);
            localStringBuilder.append(", ");
            if (paramDoutuItem == null) {
              break label408;
            }
            str = paramDoutuItem.toString();
            localStringBuilder.append(str);
            QLog.d("DoutuServiceImpl", 2, localStringBuilder.toString());
          }
          if ((paramDoutuItem != null) && (paramDoutuItem.a()) && (this.isSmartSwitchNew) && (this.mDoutuAdapter != null))
          {
            this.requestCountMap.put(Long.valueOf(this.mDoutuAdapter.i), new DoutuItem(this.mDoutuAdapter.i, 0));
            postGetRecommendPicList(paramDoutuItem, this.mUin, this.mUinType, this.mDoutuAdapter.i);
          }
        }
        if (Build.VERSION.SDK_INT >= 14) {
          localDoutuEmotionHorizonListView.setScrollX(0);
        }
        this.mDoutuLayout.setVisibility(0);
        ReportController.b(null, "dc00898", "", "", "0X800B549", "0X800B549", 0, 0, "", "", "", "");
        ReportController.b(this.mApp, "dc00898", "", "", "0X8007FA9", "0X8007FA9", 0, 0, "", "", "", "");
        if (paramMqqHandler != null)
        {
          paramMqqHandler.removeMessages(80);
          paramMqqHandler.sendEmptyMessageDelayed(80, 5000L);
        }
        return;
      }
      finally {}
      label408:
      String str = "";
    }
  }
  
  public void updataDoutuConfig(boolean paramBoolean1, boolean paramBoolean2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean3, int paramInt)
  {
    this.doutuSwitch = paramBoolean1;
    this.comboSwitch = paramBoolean2;
    this.isSmartSwitchNew = paramBoolean3;
    if (paramLong1 > 0L) {
      this.duiDuration = paramLong1;
    }
    if (paramLong2 > 0L) {
      this.comboDuration = paramLong2;
    }
    if (paramLong3 > 0L) {
      this.comboKeepTime = paramLong3;
    }
    if (paramInt > 0) {
      this.defaultCount = paramInt;
    }
  }
  
  public void updateDoutuSetting(boolean paramBoolean)
  {
    this.doutuSettingSwitch = paramBoolean;
    ((IDoutuSPUtil)QRoute.api(IDoutuSPUtil.class)).updateDoutuSettingSwitch(BaseApplication.getContext(), this.mApp.getCurrentUin(), paramBoolean);
    if (paramBoolean) {
      DuiButtonImageView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.doutu.api.impl.DoutuServiceImpl
 * JD-Core Version:    0.7.0.1
 */