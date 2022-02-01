import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyChannelPanelFragment;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.10;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.3;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.4;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.5;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.6;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.7;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.8;
import com.tencent.biz.pubaccount.readinjoy.model.ChannelCoverInfoModule.9;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.List<Lcom.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;>;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.channel_button.channel_button.Channel;
import tencent.im.oidb.channel_button.channel_button.Section;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ChannelInfo;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.ReqBody;
import tencent.im.oidb.cmd0x69f.oidb_cmd0x69f.RspBody;
import tencent.im.oidb.cmd0xbbb.oidb_cmd0xbbb.RspBody;
import tencent.im.oidb.cmd0xbbc.oidb_cmd0xbbc.PhoneInfo;
import tencent.im.oidb.cmd0xbbc.oidb_cmd0xbbc.ReqBody;
import tencent.im.oidb.cmd0xbbc.oidb_cmd0xbbc.RspBody;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.MsgChannelInfo;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.MsgGetChannelInfoRsp;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.PhoneInfo;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.ReqBody;
import tencent.im.oidb.cmd0xbe6.oidb_cmd0xbe6.RspBody;

public class puf
  extends puh
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private HashMap<Integer, List<ChannelCoverInfo>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private LinkedHashMap<Integer, ChannelCoverInfo> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<rcp> jdField_a_of_type_JavaUtilList = new ArrayList();
  private int jdField_b_of_type_Int;
  private HashMap<Integer, Integer> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private LinkedHashMap<Integer, ChannelCoverInfo> jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private int jdField_c_of_type_Int;
  private LinkedHashMap<Integer, ChannelCoverInfo> jdField_c_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  
  public puf(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, qli paramqli, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramqli, paramHandler);
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "construct!");
    }
  }
  
  public static int a()
  {
    return opx.a.a();
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_Int;
    }
    if (paramInt == 56) {
      return this.jdField_b_of_type_Int;
    }
    if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
      return ((Integer)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).intValue();
    }
    return 0;
  }
  
  private int a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = 0;
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      if (paramInt == 0) {
        i = paramQQAppInterface.getInt("readInJoy_mian_channel_cover_seq", 0);
      }
    }
    else {
      return i;
    }
    if (paramInt == 56) {
      return paramQQAppInterface.getInt("readInJoy_video_channel_cover_seq", 0);
    }
    return paramQQAppInterface.getInt("readInJoy_sub_channel_cover_seq" + paramInt, 0);
  }
  
  private ChannelCoverInfo a(int paramInt1, int paramInt2)
  {
    ChannelCoverInfo localChannelCoverInfo = null;
    localObject2 = this.jdField_a_of_type_JavaLangObject;
    if (paramInt2 == 0) {}
    for (;;)
    {
      try
      {
        localChannelCoverInfo = (ChannelCoverInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
        return localChannelCoverInfo;
      }
      finally {}
      if (paramInt2 == 56) {
        localChannelCoverInfo = (ChannelCoverInfo)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
      } else if (paramInt2 == 41402) {
        localChannelCoverInfo = (ChannelCoverInfo)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt1));
      } else if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt2))) {
        localChannelCoverInfo = a(paramInt1, (List)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt2)));
      }
    }
  }
  
  private ChannelCoverInfo a(int paramInt, List<ChannelCoverInfo> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)paramList.next();
        if (localChannelCoverInfo.mChannelCoverId == paramInt) {
          return localChannelCoverInfo;
        }
      }
    }
    return null;
  }
  
  private static TabChannelCoverInfo a()
  {
    int i;
    if (a() != -1) {
      i = a();
    }
    for (;;)
    {
      Object localObject;
      String str;
      if (!TextUtils.isEmpty(a()))
      {
        localObject = a();
        localObject = new TabChannelCoverInfo(i, (String)localObject, 4, "https://p.qpic.cn/kandianac/0/9558fc75932c5.png/0");
        str = b();
        if (TextUtils.isEmpty(str)) {}
      }
      try
      {
        ((TabChannelCoverInfo)localObject).mChannelJumpUrl = URLDecoder.decode(str, "UTF-8");
        QLog.i("ChannelCoverInfoModule", 1, "[getMainChannelInfo], channelCoverInfo = " + localObject);
        return localObject;
        i = 0;
        continue;
        localObject = amtj.a(2131700659);
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          QLog.e("ChannelCoverInfoModule", 1, "[getMainChannelInfo], e = " + localUnsupportedEncodingException);
        }
      }
    }
  }
  
  public static String a()
  {
    return opx.a.a();
  }
  
  private List<TabChannelCoverInfo> a(List<TabChannelCoverInfo> paramList, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        TabChannelCoverInfo localTabChannelCoverInfo = ((TabChannelCoverInfo)paramList.next()).clone();
        localTabChannelCoverInfo.channelConfigType = paramInt;
        localTabChannelCoverInfo.seq = i;
        localArrayList.add(localTabChannelCoverInfo);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 0)
    {
      this.jdField_a_of_type_Int = paramInt2;
      return;
    }
    if (paramInt1 == 56)
    {
      this.jdField_b_of_type_Int = paramInt2;
      return;
    }
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  private void a(ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramChannelCoverInfo.mChannelCoverId), paramChannelCoverInfo);
        return;
      }
      finally {}
      if (paramInt == 56)
      {
        this.jdField_b_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramChannelCoverInfo.mChannelCoverId), paramChannelCoverInfo);
      }
      else if (paramInt == 41402)
      {
        this.jdField_c_of_type_JavaUtilLinkedHashMap.put(Integer.valueOf(paramChannelCoverInfo.mChannelCoverId), paramChannelCoverInfo);
      }
      else if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)))
      {
        ((List)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).add(paramChannelCoverInfo);
      }
      else
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramChannelCoverInfo);
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), localArrayList);
      }
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      if (paramInt2 != 0) {
        break label106;
      }
      paramQQAppInterface.putInt("readInJoy_mian_channel_cover_seq", paramInt1);
    }
    for (;;)
    {
      paramQQAppInterface.commit();
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverInfoModule", 2, "updateChannelCoverSeqConfig, seq =" + paramInt1 + " ;channelId = " + paramInt2);
      }
      return;
      label106:
      if (paramInt2 == 56) {
        paramQQAppInterface.putInt("readInJoy_video_channel_cover_seq", paramInt1);
      } else {
        paramQQAppInterface.putInt("readInJoy_sub_channel_cover_seq" + paramInt2, paramInt1);
      }
    }
  }
  
  public static void a(List<TabChannelCoverInfo> paramList, String paramString)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramList.size())
      {
        QLog.d("ChannelCoverInfoModule", 1, new Object[] { paramString + " tabChannelCoverInfo [", Integer.valueOf(i), "]: ", ((TabChannelCoverInfo)paramList.get(i)).shortLogString() });
        i += 1;
      }
    }
  }
  
  private void a(List<rcp> paramList1, List<rcp> paramList2)
  {
    SparseArray localSparseArray = new SparseArray();
    paramList2 = paramList2.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList2.hasNext())
    {
      localObject1 = ((rcp)paramList2.next()).jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TabChannelCoverInfo)((Iterator)localObject1).next();
        localSparseArray.put(((TabChannelCoverInfo)localObject2).mChannelCoverId, localObject2);
      }
    }
    paramList2 = paramList1.iterator();
    if (paramList2.hasNext())
    {
      localObject1 = (rcp)paramList2.next();
      localObject2 = ((rcp)localObject1).jdField_a_of_type_JavaUtilList.iterator();
      label272:
      label285:
      label291:
      label296:
      label300:
      for (;;)
      {
        label120:
        TabChannelCoverInfo localTabChannelCoverInfo1;
        TabChannelCoverInfo localTabChannelCoverInfo2;
        label205:
        int i;
        if (((Iterator)localObject2).hasNext())
        {
          localTabChannelCoverInfo1 = (TabChannelCoverInfo)((Iterator)localObject2).next();
          localTabChannelCoverInfo2 = (TabChannelCoverInfo)localSparseArray.get(localTabChannelCoverInfo1.mChannelCoverId);
          if (localTabChannelCoverInfo2 != null)
          {
            if (localTabChannelCoverInfo1.redPoint == null) {
              break label272;
            }
            if ((!localTabChannelCoverInfo1.redPoint.a) && (localTabChannelCoverInfo2.redPoint != null)) {
              localTabChannelCoverInfo1.redPoint.a = localTabChannelCoverInfo2.redPoint.a;
            }
          }
          if (!pch.a()) {
            break label285;
          }
          i = 11;
          label214:
          if ((paramList1.indexOf(localObject1) != 0) || (((rcp)localObject1).jdField_a_of_type_JavaUtilList.indexOf(localTabChannelCoverInfo1) >= i)) {
            break label291;
          }
          i = 1;
          label243:
          if (ReadInJoyChannelPanelFragment.a(localTabChannelCoverInfo1) == -1) {
            break label296;
          }
        }
        for (int j = 1;; j = 0)
        {
          if ((j == 0) || (i != 0)) {
            break label300;
          }
          a(true);
          break label120;
          break;
          localTabChannelCoverInfo1.redPoint = localTabChannelCoverInfo2.redPoint;
          break label205;
          i = 6;
          break label214;
          i = 0;
          break label243;
        }
      }
    }
  }
  
  private boolean a()
  {
    if (this.jdField_c_of_type_Int < 3)
    {
      this.jdField_c_of_type_Int += 1;
      return true;
    }
    this.jdField_c_of_type_Int = 0;
    bkwm.a("UPDATE_CHANNEL_LIST_KEY_0xBBC", Boolean.valueOf(false));
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    if (!((Boolean)bkwm.a("sp_key_channel_list_dynamic_order_switch", Boolean.valueOf(false))).booleanValue())
    {
      QLog.d("ChannelCoverInfoModule", 1, "isSupportChannelDynamicOrder, switch is off.");
      return false;
    }
    Object localObject1 = (QQAppInterface)pay.a();
    if (localObject1 != null)
    {
      localObject1 = (pks)((QQAppInterface)localObject1).getManager(163);
      if (localObject1 != null)
      {
        localObject1 = ((pks)localObject1).a().a();
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          TabChannelCoverInfo localTabChannelCoverInfo;
          do
          {
            localObject1 = ((List)localObject1).iterator();
            Object localObject2;
            while (!((Iterator)localObject2).hasNext())
            {
              do
              {
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                localObject2 = ((rcp)((Iterator)localObject1).next()).jdField_a_of_type_JavaUtilList;
              } while ((localObject2 == null) || (((List)localObject2).size() <= 0));
              localObject2 = ((List)localObject2).iterator();
            }
            localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject2).next();
          } while (localTabChannelCoverInfo.mChannelCoverId != paramInt);
          QLog.d("ChannelCoverInfoModule", 1, new Object[] { "isSupportChannelDynamicOrder, name = ", localTabChannelCoverInfo.mChannelCoverName, ", channelID = ", Integer.valueOf(paramInt), ", dynamicSort = ", Integer.valueOf(localTabChannelCoverInfo.dynamicSort) });
          if (localTabChannelCoverInfo.dynamicSort == 1) {}
          for (boolean bool = true;; bool = false) {
            return bool;
          }
        }
      }
    }
    QLog.d("ChannelCoverInfoModule", 1, "isSupportChannelDynamicOrder, channel dynamic order is off.");
    return false;
  }
  
  private boolean a(ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    if (paramChannelCoverInfo == null) {
      return false;
    }
    paramChannelCoverInfo = paramChannelCoverInfo.clone();
    a(paramChannelCoverInfo, paramInt);
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ChannelCoverInfoModule.3(this, paramChannelCoverInfo));
    return true;
  }
  
  private boolean a(TabChannelCoverInfo paramTabChannelCoverInfo, List<TabChannelCoverInfo> paramList)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (paramList != null) {
      i = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramList.size())
      {
        TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)paramList.get(i);
        if ((localTabChannelCoverInfo == null) || (localTabChannelCoverInfo.mChannelCoverId != paramTabChannelCoverInfo.mChannelCoverId) || (localTabChannelCoverInfo.mChannelId != paramTabChannelCoverInfo.mChannelId)) {}
      }
      else
      {
        try
        {
          paramList.set(i, paramTabChannelCoverInfo);
          bool1 = true;
          return bool1;
        }
        catch (Exception paramTabChannelCoverInfo)
        {
          for (;;)
          {
            QLog.e("ChannelCoverInfoModule", 1, "findAndReplaceChannel channelCoverInfoList error!!,index:" + i + " size:channelCoverInfoList.size(),msg:" + paramTabChannelCoverInfo.toString());
          }
        }
      }
      i += 1;
    }
  }
  
  private static String b()
  {
    return opx.a.b();
  }
  
  private List<TabChannelCoverInfo> b(List<rcp> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i = 0;
      if (paramList.hasNext())
      {
        rcp localrcp = (rcp)paramList.next();
        if ((localrcp.jdField_a_of_type_JavaUtilList == null) || (localrcp.jdField_a_of_type_JavaUtilList.isEmpty())) {
          break label133;
        }
        Iterator localIterator = localrcp.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
          localTabChannelCoverInfo.channelConfigType = localrcp.jdField_a_of_type_Long;
          localTabChannelCoverInfo.seq = i;
          localArrayList.add(localTabChannelCoverInfo);
          i += 1;
        }
      }
    }
    label133:
    for (;;)
    {
      break;
      return localArrayList;
    }
  }
  
  private void b(int paramInt1, int paramInt2)
  {
    ChannelCoverInfo localChannelCoverInfo = a(paramInt1, paramInt2);
    if (localChannelCoverInfo != null)
    {
      QLog.i("ChannelCoverInfoModule", 1, "removeChannelCoverInfoFromDBAndCache channelID=" + paramInt2 + " ;channelCoverId = " + paramInt1);
      b(localChannelCoverInfo, paramInt2);
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ChannelCoverInfoModule.2(this, localChannelCoverInfo));
    }
  }
  
  private void b(ChannelCoverInfo paramChannelCoverInfo, int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    Iterator localIterator;
    if (paramInt == 0) {
      label61:
      break label150;
    }
    for (;;)
    {
      try
      {
        localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        if (localIterator.hasNext())
        {
          if (((Integer)localIterator.next()).intValue() != paramChannelCoverInfo.mChannelCoverId) {
            break;
          }
          localIterator.remove();
        }
        return;
      }
      finally {}
      if (paramInt == 56)
      {
        localIterator = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        if (((Integer)localIterator.next()).intValue() != paramChannelCoverInfo.mChannelCoverId) {
          break label61;
        }
        localIterator.remove();
        continue;
      }
      if (paramInt == 41402)
      {
        localIterator = this.jdField_c_of_type_JavaUtilLinkedHashMap.keySet().iterator();
        label150:
        if (!localIterator.hasNext()) {
          continue;
        }
        if (((Integer)localIterator.next()).intValue() != paramChannelCoverInfo.mChannelCoverId) {
          break label61;
        }
        localIterator.remove();
        continue;
      }
      if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt))) {
        ((List)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).remove(paramChannelCoverInfo);
      }
    }
  }
  
  private void b(boolean paramBoolean, List<TabChannelCoverInfo> paramList)
  {
    if (Looper.getMainLooper() == Looper.myLooper()) {
      pkp.a().e(paramBoolean, paramList);
    }
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ChannelCoverInfoModule.6(this, paramBoolean, paramList));
  }
  
  private List<rcp> c(List<rcp> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        Object localObject = (rcp)paramList.next();
        rcp localrcp = new rcp(((rcp)localObject).jdField_a_of_type_Long, ((rcp)localObject).jdField_a_of_type_JavaLangString, ((rcp)localObject).b);
        localObject = ((rcp)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          TabChannelCoverInfo localTabChannelCoverInfo1 = (TabChannelCoverInfo)((Iterator)localObject).next();
          TabChannelCoverInfo localTabChannelCoverInfo2 = localTabChannelCoverInfo1.clone();
          localTabChannelCoverInfo2.channelConfigType = localTabChannelCoverInfo1.channelConfigType;
          localTabChannelCoverInfo2.seq = i;
          localrcp.jdField_a_of_type_JavaUtilList.add(localTabChannelCoverInfo2);
          i += 1;
        }
        localArrayList.add(localrcp);
      }
    }
    return localArrayList;
  }
  
  private List<TabChannelCoverInfo> d(List<TabChannelCoverInfo> paramList)
  {
    Object localObject1 = null;
    Object localObject2 = paramList;
    if (paramList == null) {
      localObject2 = new ArrayList();
    }
    Iterator localIterator = ((List)localObject2).iterator();
    int i = 0;
    Object localObject4 = null;
    Object localObject3 = null;
    boolean bool2 = true;
    boolean bool1 = true;
    paramList = (List<TabChannelCoverInfo>)localObject1;
    if (localIterator.hasNext())
    {
      localObject1 = (TabChannelCoverInfo)localIterator.next();
      if (((TabChannelCoverInfo)localObject1).mChannelCoverId == 0)
      {
        localObject3 = localObject1;
        bool2 = false;
      }
      if (((TabChannelCoverInfo)localObject1).mChannelCoverId == 70)
      {
        localObject4 = localObject1;
        bool1 = false;
      }
      if (((TabChannelCoverInfo)localObject1).mChannelCoverId != a()) {
        break label236;
      }
      i = 1;
    }
    for (;;)
    {
      paramList = (List<TabChannelCoverInfo>)localObject1;
      break;
      if (i != 0) {
        ((List)localObject2).remove(paramList);
      }
      if (!bool2) {
        ((List)localObject2).remove(localObject3);
      }
      ((List)localObject2).add(0, a());
      if (!bool1)
      {
        ((List)localObject2).remove(localObject4);
        ((List)localObject2).add(0, new TabChannelCoverInfo(70, amtj.a(2131700682), 4, "https://p.qpic.cn/kandianac/0/993c416b9d2b9.png/0"));
      }
      QLog.d("ChannelCoverInfoModule", 1, new Object[] { "forceInsertChannelList insertRecommendChannel = ", Boolean.valueOf(bool2), ", insertFollowChannel = ", Boolean.valueOf(bool1) });
      return localObject2;
      label236:
      localObject1 = paramList;
    }
  }
  
  private List<ChannelCoverInfo> e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "loadFromDb with selection=" + "mChannelID = ?" + ", channelId=" + paramInt);
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(ChannelCoverInfo.class, true, "mChannelID = ?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
  }
  
  private void e()
  {
    for (;;)
    {
      try
      {
        localReqBody = new oidb_cmd0xbe6.ReqBody();
        localPhoneInfo = new oidb_cmd0xbe6.PhoneInfo();
        str = pay.i();
        if (!TextUtils.isEmpty(str))
        {
          str = MD5Utils.toMD5(str.toLowerCase()).toLowerCase();
          localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(str));
          localPhoneInfo.uint32_muid_type.set(1);
          i = nyj.a();
          localPhoneInfo.uint32_conn.set(i);
          i = 0;
        }
      }
      catch (Throwable localThrowable)
      {
        oidb_cmd0xbe6.ReqBody localReqBody;
        oidb_cmd0xbe6.PhoneInfo localPhoneInfo;
        String str;
        int i;
        int j;
        QLog.e("ChannelCoverInfoModule", 2, "requestWeiShiChannelCoverListFromServer failed for param error:" + pay.a(localThrowable));
        return;
      }
      try
      {
        j = DeviceInfoUtil.getCarrier();
        i = j;
      }
      catch (Exception localException)
      {
        continue;
      }
      localPhoneInfo.uint32_carrier.set(i);
      str = DeviceInfoUtil.getDeviceOSVersion();
      localPhoneInfo.bytes_os_ver.set(ByteStringMicro.copyFromUtf8(str));
      str = DeviceInfoUtil.getQQVersion();
      localPhoneInfo.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8(str));
      i = AppSetting.a();
      localPhoneInfo.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
      str = dw.a(dw.a());
      localPhoneInfo.bytes_client_ip.set(ByteStringMicro.copyFromUtf8(str));
      localPhoneInfo.uint32_os_type.set(2);
      localReqBody.msg_phone_info.set(localPhoneInfo, true);
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        localReqBody.string_channel_version.set(a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface));
      }
      a(qlk.a("OidbSvc.0xbe6", 3046, 1, localReqBody.toByteArray()));
      return;
      str = DeviceInfoUtil.getLocalMacAddress(BaseApplication.getContext());
      if (!TextUtils.isEmpty(str))
      {
        str = MD5Utils.toMD5(str.replaceAll(":", "").toUpperCase()).toLowerCase();
        localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(str));
        localPhoneInfo.uint32_muid_type.set(3);
      }
    }
  }
  
  private void g(List<rcp> paramList)
  {
    if (paramList != null) {
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject = (rcp)paramList.next();
          if (localObject != null)
          {
            localObject = ((rcp)localObject).jdField_a_of_type_JavaUtilList;
            if (localObject != null)
            {
              localObject = ((List)localObject).iterator();
              while (((Iterator)localObject).hasNext())
              {
                TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
                if (localTabChannelCoverInfo != null)
                {
                  if (!TextUtils.isEmpty(localTabChannelCoverInfo.mIconUrl)) {
                    URLDrawable.getDrawable(localTabChannelCoverInfo.mIconUrl, true).downloadImediatly();
                  }
                  if (!TextUtils.isEmpty(localTabChannelCoverInfo.mChannelCoverPicUrl)) {
                    URLDrawable.getDrawable(localTabChannelCoverInfo.mChannelCoverPicUrl, true).downloadImediatly();
                  }
                }
              }
            }
          }
        }
        return;
      }
      catch (Exception paramList)
      {
        QLog.e("ChannelCoverInfoModule", 1, paramList.getMessage());
      }
    }
  }
  
  private List<ChannelCoverInfo> h()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
      Iterator localIterator = this.jdField_a_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        localArrayList.add((ChannelCoverInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(localInteger));
      }
    }
    return localList;
  }
  
  private List<ChannelCoverInfo> i()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_b_of_type_JavaUtilLinkedHashMap.size());
      Iterator localIterator = this.jdField_b_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        localArrayList.add((ChannelCoverInfo)this.jdField_b_of_type_JavaUtilLinkedHashMap.get(localInteger));
      }
    }
    return localList;
  }
  
  private List<ChannelCoverInfo> j()
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ArrayList localArrayList = new ArrayList(this.jdField_c_of_type_JavaUtilLinkedHashMap.size());
      Iterator localIterator = this.jdField_c_of_type_JavaUtilLinkedHashMap.keySet().iterator();
      if (localIterator.hasNext())
      {
        Integer localInteger = (Integer)localIterator.next();
        localArrayList.add((ChannelCoverInfo)this.jdField_c_of_type_JavaUtilLinkedHashMap.get(localInteger));
      }
    }
    return localList;
  }
  
  private List<TabChannelCoverInfo> k()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new TabChannelCoverInfo(51, amtj.a(2131700688)));
    localArrayList.add(new TabChannelCoverInfo(58, amtj.a(2131700675)));
    localArrayList.add(new TabChannelCoverInfo(59, amtj.a(2131700674)));
    localArrayList.add(new TabChannelCoverInfo(10, amtj.a(2131700677)));
    localArrayList.add(new TabChannelCoverInfo(52, amtj.a(2131700690)));
    localArrayList.add(new TabChannelCoverInfo(53, amtj.a(2131700671)));
    localArrayList.add(new TabChannelCoverInfo(9, amtj.a(2131700681)));
    localArrayList.add(new TabChannelCoverInfo(54, amtj.a(2131700666)));
    localArrayList.add(new TabChannelCoverInfo(55, amtj.a(2131700668)));
    localArrayList.add(new TabChannelCoverInfo(40007, amtj.a(2131700670)));
    return localArrayList;
  }
  
  private List<TabChannelCoverInfo> l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "loadFromDb");
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManager.query(TabChannelCoverInfo.class);
  }
  
  public String a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0).getString("readInJoy_weishi_channel_cover_seq", "");
  }
  
  /* Error */
  public List<TabChannelCoverInfo> a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	puf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 49	puf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   13: invokeinterface 435 1 0
    //   18: ifne +24 -> 42
    //   21: aload_0
    //   22: getfield 49	puf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   25: iconst_0
    //   26: invokeinterface 285 2 0
    //   31: checkcast 298	rcp
    //   34: getfield 299	rcp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   37: astore_1
    //   38: aload_0
    //   39: monitorexit
    //   40: aload_1
    //   41: areturn
    //   42: aconst_null
    //   43: astore_1
    //   44: goto -6 -> 38
    //   47: astore_1
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_1
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	52	0	this	puf
    //   37	7	1	localList	List
    //   47	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	38	47	finally
  }
  
  /* Error */
  public List<TabChannelCoverInfo> a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 49	puf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 49	puf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   13: iload_1
    //   14: invokeinterface 285 2 0
    //   19: checkcast 298	rcp
    //   22: getfield 299	rcp:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   25: astore_2
    //   26: aload_0
    //   27: monitorexit
    //   28: aload_2
    //   29: areturn
    //   30: aconst_null
    //   31: astore_2
    //   32: goto -6 -> 26
    //   35: astore_2
    //   36: aload_0
    //   37: monitorexit
    //   38: aload_2
    //   39: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	40	0	this	puf
    //   0	40	1	paramInt	int
    //   25	7	2	localList	List
    //   35	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	26	35	finally
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "unInitialize!");
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_b_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_c_of_type_JavaUtilLinkedHashMap.clear();
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      this.jdField_b_of_type_JavaUtilHashMap.clear();
      return;
    }
  }
  
  public void a(int paramInt, String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "updateMainChannelCoverInfo, channelCoverId = " + paramInt + " ;articleTitle = " + paramString + " ;articleId = " + paramLong);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.get(Integer.valueOf(paramInt));
      if (localChannelCoverInfo != null)
      {
        localChannelCoverInfo.mChannelCoverSummary = paramString;
        localChannelCoverInfo.mArticleId = paramLong;
        a(localChannelCoverInfo, 0);
        f(h(), 0);
      }
      return;
    }
  }
  
  @UiThread
  public void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("updateChannel: ");
    if (paramTabChannelCoverInfo != null) {}
    for (Object localObject = paramTabChannelCoverInfo.toString();; localObject = "null")
    {
      QLog.d("ChannelCoverInfoModule", 2, (String)localObject);
      if (paramTabChannelCoverInfo == null) {
        return;
      }
      paramTabChannelCoverInfo = paramTabChannelCoverInfo.clone();
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break;
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (a(paramTabChannelCoverInfo, ((rcp)((Iterator)localObject).next()).jdField_a_of_type_JavaUtilList)) {
          QLog.d("ChannelCoverInfoModule", 2, "updateChannel found in channelCoverInfoList!");
        }
      }
    }
    ThreadManager.getFileThreadHandler().post(new ChannelCoverInfoModule.1(this, paramTabChannelCoverInfo));
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putString("readInJoy_weishi_channel_cover_seq", paramString);
      paramQQAppInterface.commit();
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverInfoModule", 2, "updateChannelCoverSeqConfig, version =" + paramString);
      }
    }
  }
  
  public void a(List<channel_button.Section> paramList)
  {
    if (paramList == null) {}
    for (;;)
    {
      try
      {
        QLog.d("ChannelCoverInfoModule", 1, "saveChannelSection null");
        return;
      }
      finally {}
      List localList = this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList.size());
      JSONArray localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      if (paramList.hasNext())
      {
        channel_button.Section localSection = (channel_button.Section)paramList.next();
        rcp localrcp = new rcp(localSection);
        localJSONArray.put(localrcp.a());
        localrcp.jdField_a_of_type_JavaUtilList = qlh.b(localSection.rpt_msg_channel.get());
        this.jdField_a_of_type_JavaUtilList.add(localrcp);
        a(localrcp.jdField_a_of_type_JavaUtilList, "saveChannelSection " + localrcp.jdField_a_of_type_Long);
      }
      else
      {
        a(this.jdField_a_of_type_JavaUtilList, localList);
        c(this.jdField_a_of_type_JavaUtilList);
        a(localList, this.jdField_a_of_type_JavaUtilList, true);
        if (localJSONArray.length() > 0) {
          ThreadManager.executeOnFileThread(new ChannelCoverInfoModule.10(this, localJSONArray));
        }
      }
    }
  }
  
  public void a(List<rcp> paramList, int paramInt)
  {
    QLog.d("ChannelCoverInfoModule", 1, "requestUpdateChannelLists. ");
    if ((paramList == null) || (paramList.isEmpty()))
    {
      QLog.d("ChannelCoverInfoModule", 2, "mChannelSectionList is null, do not requestUpdateChannelLists.");
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = paramList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (rcp)((Iterator)localObject1).next();
        a(((rcp)localObject2).jdField_a_of_type_JavaUtilList, "0xbbc update sectionId=" + ((rcp)localObject2).jdField_a_of_type_Long);
      }
    }
    Object localObject1 = new oidb_cmd0xbbc.ReqBody();
    Object localObject2 = new ArrayList();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      rcp localrcp = (rcp)localIterator1.next();
      channel_button.Section localSection = new channel_button.Section();
      ArrayList localArrayList = new ArrayList();
      if (localrcp.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator2 = localrcp.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator2.hasNext())
        {
          paramList = (TabChannelCoverInfo)localIterator2.next();
          channel_button.Channel localChannel = new channel_button.Channel();
          localChannel.uint64_channel_id.set(paramList.mChannelCoverId);
          localChannel.enum_reason.set(paramList.reason);
          PBStringField localPBStringField = localChannel.str_proxy;
          if (TextUtils.isEmpty(paramList.proxy)) {}
          for (paramList = "";; paramList = paramList.proxy)
          {
            localPBStringField.set(paramList);
            localArrayList.add(localChannel);
            break;
          }
        }
      }
      if (!localArrayList.isEmpty())
      {
        localSection.uint64_section_id.set(localrcp.jdField_a_of_type_Long);
        localSection.str_section_name.set(localrcp.jdField_a_of_type_JavaLangString);
        localSection.str_note_text.set(localrcp.b);
        localSection.rpt_msg_channel.set(localArrayList);
        ((List)localObject2).add(localSection);
      }
    }
    ((oidb_cmd0xbbc.ReqBody)localObject1).rpt_msg_section.set((List)localObject2);
    paramList = new oidb_cmd0xbbc.PhoneInfo();
    localObject2 = pay.i();
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = MD5Utils.toMD5(((String)localObject2).toLowerCase()).toLowerCase();
      paramList.bytes_muid.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      paramList.uint32_muid_type.set(1);
    }
    for (;;)
    {
      int i = nyj.a();
      paramList.uint32_conn.set(i);
      i = 0;
      try
      {
        int j = DeviceInfoUtil.getCarrier();
        i = j;
      }
      catch (Exception localException)
      {
        label450:
        break label450;
      }
      paramList.uint32_carrier.set(i);
      localObject2 = DeviceInfoUtil.getDeviceOSVersion();
      paramList.bytes_os_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localObject2 = DeviceInfoUtil.getQQVersion();
      paramList.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      i = AppSetting.a();
      paramList.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
      localObject2 = dw.a(dw.a());
      paramList.bytes_client_ip.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      paramList.uint32_os_type.set(2);
      ((oidb_cmd0xbbc.ReqBody)localObject1).msg_phone_type.set(paramList, true);
      ((oidb_cmd0xbbc.ReqBody)localObject1).uint32_set_type.set(paramInt);
      a(qlk.a("OidbSvc.0xbbc", 3004, 1, ((oidb_cmd0xbbc.ReqBody)localObject1).toByteArray()));
      bkwm.a("UPDATE_CHANNEL_LIST_KEY_0xBBC", Boolean.valueOf(true));
      return;
      localObject2 = DeviceInfoUtil.getLocalMacAddress(BaseApplication.getContext());
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = MD5Utils.toMD5(((String)localObject2).replaceAll(":", "").toUpperCase()).toLowerCase();
        paramList.bytes_muid.set(ByteStringMicro.copyFromUtf8((String)localObject2));
        paramList.uint32_muid_type.set(3);
      }
    }
  }
  
  public void a(List<rcp> paramList1, List<rcp> paramList2, boolean paramBoolean)
  {
    if (paramList1 == null) {}
    try
    {
      QLog.d("ChannelCoverInfoModule", 1, "[saveChannelInfoListInCacheAndDb] oldSectionList is null");
      if (paramList2 == null) {
        QLog.d("ChannelCoverInfoModule", 1, "[saveChannelInfoListInCacheAndDb] sectionList is null");
      }
      paramList1 = b(paramList1);
      ((rcp)paramList2.get(0)).jdField_a_of_type_JavaUtilList = d(((rcp)paramList2.get(0)).jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_JavaUtilList = c(paramList2);
      paramList2 = b(this.jdField_a_of_type_JavaUtilList);
      if (paramBoolean) {
        b(true, ((rcp)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaUtilList);
      }
      QLog.i("ChannelCoverInfoModule", 1, "saveChannelInfoListInCacheAndDb remove oldList");
      localIterator = paramList1.iterator();
      while (localIterator.hasNext()) {
        QLog.i("ChannelCoverInfoModule", 1, ((TabChannelCoverInfo)localIterator.next()).toString());
      }
      QLog.i("ChannelCoverInfoModule", 1, "saveChannelInfoListInCacheAndDb save newList");
    }
    finally {}
    Iterator localIterator = paramList2.iterator();
    while (localIterator.hasNext()) {
      QLog.i("ChannelCoverInfoModule", 1, ((TabChannelCoverInfo)localIterator.next()).toString());
    }
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ChannelCoverInfoModule.9(this, paramList1, paramList2));
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ChannelCoverInfoModule.8(this, paramBoolean));
    }
  }
  
  public List<TabChannelCoverInfo> b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new TabChannelCoverInfo(70, amtj.a(2131700673), 4, "https://p.qpic.cn/kandianac/0/993c416b9d2b9.png/0"));
    localArrayList.add(new TabChannelCoverInfo(0, amtj.a(2131700672), 4, "https://p.qpic.cn/kandianac/0/9558fc75932c5.png/0"));
    TabChannelCoverInfo localTabChannelCoverInfo = new TabChannelCoverInfo(56, amtj.a(2131700683));
    localTabChannelCoverInfo.reason = 4;
    localTabChannelCoverInfo.mChannelType = 3;
    localArrayList.add(localTabChannelCoverInfo);
    localArrayList.add(new TabChannelCoverInfo(40531, amtj.a(2131700685)));
    localArrayList.add(new TabChannelCoverInfo(14, amtj.a(2131700669)));
    localArrayList.add(new TabChannelCoverInfo(8, amtj.a(2131700687)));
    localArrayList.add(new TabChannelCoverInfo(1, amtj.a(2131700676)));
    localArrayList.add(new TabChannelCoverInfo(13, amtj.a(2131700662)));
    localArrayList.add(new TabChannelCoverInfo(5, amtj.a(2131700692)));
    localArrayList.add(new TabChannelCoverInfo(11, amtj.a(2131700661)));
    localArrayList.add(new TabChannelCoverInfo(40466, amtj.a(2131700686)));
    localArrayList.add(new TabChannelCoverInfo(40013, amtj.a(2131700684)));
    localArrayList.add(new TabChannelCoverInfo(16, amtj.a(2131700679)));
    localArrayList.add(new TabChannelCoverInfo(15, amtj.a(2131700665)));
    return localArrayList;
  }
  
  public List<ChannelCoverInfo> b(int paramInt)
  {
    List localList = null;
    if (paramInt == 0) {
      localList = h();
    }
    do
    {
      return localList;
      if (paramInt == 56) {
        return i();
      }
      if (paramInt == 41402) {
        return j();
      }
    } while (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(paramInt)));
    return new ArrayList((Collection)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)));
  }
  
  /* Error */
  public void b()
  {
    // Byte code:
    //   0: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 57
    //   8: iconst_2
    //   9: ldc_w 979
    //   12: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: ldc_w 343
    //   18: iconst_0
    //   19: invokestatic 348	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   22: invokestatic 359	bkwm:a	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   25: checkcast 345	java/lang/Boolean
    //   28: invokevirtual 362	java/lang/Boolean:booleanValue	()Z
    //   31: ifeq +29 -> 60
    //   34: aload_0
    //   35: invokespecial 980	puf:a	()Z
    //   38: ifeq +22 -> 60
    //   41: ldc 57
    //   43: iconst_2
    //   44: ldc_w 982
    //   47: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_0
    //   51: aload_0
    //   52: getfield 49	puf:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   55: iconst_3
    //   56: invokevirtual 984	puf:a	(Ljava/util/List;I)V
    //   59: return
    //   60: getstatic 987	ojc:a	Z
    //   63: ifeq +13 -> 76
    //   66: ldc 57
    //   68: iconst_2
    //   69: ldc_w 989
    //   72: invokestatic 63	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: return
    //   76: invokestatic 994	java/lang/System:currentTimeMillis	()J
    //   79: ldc2_w 995
    //   82: ldiv
    //   83: aload_0
    //   84: getfield 997	puf:jdField_a_of_type_Long	J
    //   87: lcmp
    //   88: iflt -29 -> 59
    //   91: new 999	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody
    //   94: dup
    //   95: invokespecial 1000	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:<init>	()V
    //   98: astore_2
    //   99: aload_2
    //   100: getfield 1003	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:bytes_city	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   103: invokestatic 1008	com/tencent/mobileqq/app/soso/LbsManagerService:getCity	()Ljava/lang/String;
    //   106: invokestatic 563	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   109: invokevirtual 568	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   112: aload_2
    //   113: getfield 1011	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:str_city	Lcom/tencent/mobileqq/pb/PBStringField;
    //   116: invokestatic 1014	com/tencent/mobileqq/app/soso/LbsManagerService:getCityCode	()Ljava/lang/String;
    //   119: invokevirtual 645	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   122: aload_0
    //   123: getfield 633	puf:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   126: bipush 51
    //   128: invokevirtual 1017	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   131: checkcast 1019	amsw
    //   134: aload_0
    //   135: getfield 633	puf:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   138: checkcast 97	com/tencent/mobileqq/app/QQAppInterface
    //   141: invokevirtual 1022	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   144: invokevirtual 1025	amsw:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   147: astore_3
    //   148: aload_3
    //   149: ifnull +25 -> 174
    //   152: aload_2
    //   153: getfield 1028	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   156: aload_3
    //   157: getfield 1033	com/tencent/mobileqq/data/Friends:age	I
    //   160: invokevirtual 577	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   163: aload_2
    //   164: getfield 1036	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:uint32_sex	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   167: aload_3
    //   168: getfield 1040	com/tencent/mobileqq/data/Friends:gender	B
    //   171: invokevirtual 577	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   174: new 1042	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo
    //   177: dup
    //   178: invokespecial 1043	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:<init>	()V
    //   181: astore_3
    //   182: invokestatic 544	pay:i	()Ljava/lang/String;
    //   185: astore 4
    //   187: aload 4
    //   189: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   192: ifne +330 -> 522
    //   195: aload 4
    //   197: invokevirtual 547	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   200: astore 4
    //   202: aload 4
    //   204: invokestatic 553	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   207: invokevirtual 547	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   210: astore 4
    //   212: aload_3
    //   213: getfield 1044	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_muid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   216: aload 4
    //   218: invokestatic 563	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   221: invokevirtual 568	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   224: aload_3
    //   225: getfield 1045	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_muid_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   228: iconst_1
    //   229: invokevirtual 577	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   232: invokestatic 580	nyj:a	()I
    //   235: istore_1
    //   236: aload_3
    //   237: getfield 1046	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_conn	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   240: iload_1
    //   241: invokevirtual 577	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   244: invokestatic 588	com/tencent/mobileqq/utils/DeviceInfoUtil:getCarrier	()I
    //   247: istore_1
    //   248: aload_3
    //   249: getfield 1047	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_carrier	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   252: iload_1
    //   253: invokevirtual 577	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   256: invokestatic 594	com/tencent/mobileqq/utils/DeviceInfoUtil:getDeviceOSVersion	()Ljava/lang/String;
    //   259: astore 4
    //   261: aload_3
    //   262: getfield 1048	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_os_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   265: aload 4
    //   267: invokestatic 563	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   270: invokevirtual 568	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   273: invokestatic 600	com/tencent/mobileqq/utils/DeviceInfoUtil:getQQVersion	()Ljava/lang/String;
    //   276: astore 4
    //   278: aload_3
    //   279: getfield 1049	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_qq_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   282: aload 4
    //   284: invokestatic 563	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   287: invokevirtual 568	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   290: invokestatic 606	com/tencent/common/config/AppSetting:a	()I
    //   293: istore_1
    //   294: aload_3
    //   295: getfield 1050	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_appid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   298: iload_1
    //   299: invokestatic 527	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   302: invokestatic 563	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   305: invokevirtual 568	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   308: invokestatic 614	dw:a	()J
    //   311: invokestatic 617	dw:a	(J)Ljava/lang/String;
    //   314: astore 4
    //   316: aload_3
    //   317: getfield 1051	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_client_ip	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   320: aload 4
    //   322: invokestatic 563	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   325: invokevirtual 568	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   328: aload_3
    //   329: getfield 1052	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_os_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   332: iconst_2
    //   333: invokevirtual 577	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   336: aload_2
    //   337: getfield 1055	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:msg_phone_type	Ltencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo;
    //   340: aload_3
    //   341: iconst_1
    //   342: invokevirtual 1056	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;Z)V
    //   345: invokestatic 1057	pkm:a	()Lpkm;
    //   348: invokevirtual 1060	pkm:a	()Lcom/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule;
    //   351: astore_3
    //   352: aload_3
    //   353: ifnull +132 -> 485
    //   356: aload_3
    //   357: invokevirtual 1065	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule:a	()Lcom/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData;
    //   360: astore_3
    //   361: invokestatic 55	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   364: ifeq +29 -> 393
    //   367: ldc 57
    //   369: iconst_2
    //   370: new 103	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 104	java/lang/StringBuilder:<init>	()V
    //   377: ldc_w 1067
    //   380: invokevirtual 110	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload_3
    //   384: invokevirtual 207	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 210	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   393: aload_3
    //   394: ifnull +91 -> 485
    //   397: aload_3
    //   398: getfield 1072	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:city	Ljava/lang/String;
    //   401: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   404: ifne +81 -> 485
    //   407: new 1074	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo
    //   410: dup
    //   411: invokespecial 1075	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:<init>	()V
    //   414: astore 4
    //   416: aload 4
    //   418: getfield 1076	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:bytes_city	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   421: aload_3
    //   422: getfield 1072	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:city	Ljava/lang/String;
    //   425: invokestatic 563	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   428: invokevirtual 568	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   431: aload 4
    //   433: getfield 1079	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:bytes_province	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   436: aload_3
    //   437: getfield 1082	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:province	Ljava/lang/String;
    //   440: invokestatic 563	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   443: invokevirtual 568	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   446: aload 4
    //   448: getfield 1085	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:bytes_country	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   451: aload_3
    //   452: getfield 1088	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:country	Ljava/lang/String;
    //   455: invokestatic 563	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   458: invokevirtual 568	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   461: aload 4
    //   463: getfield 1091	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:bytes_city_code	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   466: aload_3
    //   467: getfield 1094	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:cityCode	Ljava/lang/String;
    //   470: invokestatic 563	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   473: invokevirtual 568	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   476: aload_2
    //   477: getfield 1098	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:msg_location_info	Ltencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo;
    //   480: aload 4
    //   482: invokevirtual 1101	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   485: aload_0
    //   486: ldc_w 1103
    //   489: sipush 3003
    //   492: iconst_1
    //   493: aload_2
    //   494: invokevirtual 1104	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:toByteArray	()[B
    //   497: invokestatic 656	qlk:a	(Ljava/lang/String;II[B)Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   500: invokevirtual 659	puf:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   503: return
    //   504: astore 4
    //   506: aload_3
    //   507: getfield 1044	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_muid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   510: ldc_w 673
    //   513: invokestatic 563	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   516: invokevirtual 568	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   519: goto -295 -> 224
    //   522: invokestatic 665	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   525: invokestatic 669	com/tencent/mobileqq/utils/DeviceInfoUtil:getLocalMacAddress	(Landroid/content/Context;)Ljava/lang/String;
    //   528: astore 4
    //   530: aload 4
    //   532: invokestatic 181	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   535: ifne -303 -> 232
    //   538: aload 4
    //   540: ldc_w 671
    //   543: ldc_w 673
    //   546: invokevirtual 676	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   549: invokevirtual 679	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   552: invokestatic 553	com/tencent/open/base/MD5Utils:toMD5	(Ljava/lang/String;)Ljava/lang/String;
    //   555: invokevirtual 547	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   558: astore 4
    //   560: aload_3
    //   561: getfield 1044	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_muid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   564: aload 4
    //   566: invokestatic 563	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   569: invokevirtual 568	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   572: aload_3
    //   573: getfield 1045	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_muid_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   576: iconst_3
    //   577: invokevirtual 577	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   580: goto -348 -> 232
    //   583: astore 4
    //   585: iconst_0
    //   586: istore_1
    //   587: goto -339 -> 248
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	590	0	this	puf
    //   235	352	1	i	int
    //   98	396	2	localReqBody	tencent.im.oidb.cmd0xbbb.oidb_cmd0xbbb.ReqBody
    //   147	426	3	localObject1	Object
    //   185	296	4	localObject2	Object
    //   504	1	4	localException1	Exception
    //   528	37	4	str	String
    //   583	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   202	224	504	java/lang/Exception
    //   244	248	583	java/lang/Exception
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "requestChannelCoverListFromServer");
    }
    if (paramInt == 41402)
    {
      e();
      return;
    }
    Object localObject = new oidb_cmd0x69f.ReqBody();
    long l = Long.valueOf(pay.a()).longValue();
    ((oidb_cmd0x69f.ReqBody)localObject).uint64_uin.set(l);
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_jump_url.set(1);
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_id.set(paramInt);
    ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_cover.set(1);
    if (paramInt == 0)
    {
      ((oidb_cmd0x69f.ReqBody)localObject).uint64_req_ctrl_bits.set(7L);
      int j = a(paramInt);
      int i = j;
      if (j == 0)
      {
        i = j;
        if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
        {
          i = j;
          if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
            i = a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramInt);
          }
        }
      }
      ((oidb_cmd0x69f.ReqBody)localObject).uint32_req_channel_seq.set(i);
      localObject = qlk.a("OidbSvc.0x69f", 1695, 0, ((oidb_cmd0x69f.ReqBody)localObject).toByteArray());
      if (paramInt != 0) {
        break label247;
      }
      ((ToServiceMsg)localObject).getAttributes().put("req_channellist_source", Integer.valueOf(3));
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).getAttributes().put("req_channellist_channel_id", Integer.valueOf(paramInt));
      a((ToServiceMsg)localObject);
      return;
      if (paramInt == 56)
      {
        ((oidb_cmd0x69f.ReqBody)localObject).uint64_req_ctrl_bits.set(3L);
        break;
      }
      ((oidb_cmd0x69f.ReqBody)localObject).uint64_req_ctrl_bits.set(4L);
      break;
      label247:
      if (paramInt == 56) {
        ((ToServiceMsg)localObject).getAttributes().put("req_channellist_source", Integer.valueOf(4));
      }
    }
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xbbb.RspBody();
    int i = qlk.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    QLog.d("ChannelCoverInfoModule", 1, "handle0xbbbGetChannelList, result=" + i);
    if (i == 0)
    {
      if ((paramToServiceMsg.uint64_next_req_time.has()) && (paramToServiceMsg.uint64_next_req_time.get() > 0L)) {
        this.jdField_a_of_type_Long = paramToServiceMsg.uint64_next_req_time.get();
      }
      if (paramToServiceMsg.rpt_msg_section.has()) {
        a(paramToServiceMsg.rpt_msg_section.get());
      }
      return;
    }
    b(false, null);
  }
  
  public void b(List<oidb_cmd0x69f.ChannelInfo> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList, list is empty");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("saveChannelCoverList channelID=" + paramInt + "\n");; localStringBuilder = null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo1 = qlh.a((oidb_cmd0x69f.ChannelInfo)paramList.next(), paramInt);
        if ((localChannelCoverInfo1.mChannelCoverName == null) || ("".equals(localChannelCoverInfo1.mChannelCoverName)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList coverName is null, filter this info");
          }
        }
        else
        {
          a(localChannelCoverInfo1);
          if ((localChannelCoverInfo1.mChannelCoverSummary == null) || ("".equals(localChannelCoverInfo1.mChannelCoverSummary)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList coverSummary is null");
            }
            ChannelCoverInfo localChannelCoverInfo2 = a(localChannelCoverInfo1.mChannelCoverId, paramInt);
            if ((localChannelCoverInfo2 != null) && (localChannelCoverInfo2.mChannelCoverSummary != null) && (!"".equals(localChannelCoverInfo2.mChannelCoverSummary)))
            {
              localChannelCoverInfo1.mChannelCoverSummary = localChannelCoverInfo2.mChannelCoverSummary;
              if (QLog.isColorLevel()) {
                QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList modify coverSummary, summary is " + localChannelCoverInfo2.mChannelCoverSummary);
              }
            }
          }
          localArrayList.add(localChannelCoverInfo1);
          if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
            localStringBuilder.append("[channelCoverId=").append(localChannelCoverInfo1.mChannelCoverId).append(", mChannelCoverName=").append(localChannelCoverInfo1.mChannelCoverName).append(", mChannelCoverStyle=").append(localChannelCoverInfo1.mChannelCoverStyle).append(", mChannelCoverSummary=").append(localChannelCoverInfo1.mChannelCoverSummary).append(", mChannelCoverPicUrl=").append(localChannelCoverInfo1.mChannelCoverPicUrl).append(", mChannelJumpUrl=").append(localChannelCoverInfo1.mChannelJumpUrl).append(", mArticleIds=").append(localChannelCoverInfo1.mArticleId).append(", mChannelType=").append(localChannelCoverInfo1.mChannelType).append(", isExternalExposure = ").append(localChannelCoverInfo1.isExternalExposure).append(", externalExposureIcon : ").append(localChannelCoverInfo1.externalExposureBackgroundUrl).append("]\n");
          }
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.d("ChannelCoverInfoModule", 2, localStringBuilder.toString());
      }
      e(localArrayList, paramInt);
      return;
    }
  }
  
  public List<rcp> c()
  {
    int i = 0;
    try
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = FileUtils.readFileContent(new File(BaseApplicationImpl.getApplication().getDir("readinjoy", 0).getAbsolutePath() + "/channel_section_data"));
      if (localObject2 != null) {
        try
        {
          localObject2 = new JSONArray((String)localObject2);
          while (i < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).optJSONObject(i);
            if (localJSONObject != null) {
              localArrayList.add(new rcp(localJSONObject));
            }
            i += 1;
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
      return localArrayList;
    }
    finally {}
  }
  
  public void c()
  {
    try
    {
      if (this.jdField_a_of_type_JavaUtilList == null)
      {
        this.jdField_a_of_type_JavaUtilList = new ArrayList();
        this.jdField_a_of_type_JavaUtilList.add(new rcp(TabChannelCoverInfo.TYPE_CHANNEL_MY_CONFIG, amtj.a(2131700660), amtj.a(2131700664)));
        this.jdField_a_of_type_JavaUtilList.add(new rcp(TabChannelCoverInfo.TYPE_CHANNEL_RECOMMEND_CONFIG, amtj.a(2131700667), amtj.a(2131700678)));
      }
      this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ChannelCoverInfoModule.4(this));
      return;
    }
    finally {}
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ChannelCoverInfoModule.5(this, paramInt));
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = qlk.a(paramFromServiceMsg, paramObject, new oidb_cmd0xbbc.RspBody());
    QLog.d("ChannelCoverInfoModule", 1, new Object[] { "handleOxbbcUpChannelList, result = ", Integer.valueOf(i) });
    if (i == 0)
    {
      bkwm.a("UPDATE_CHANNEL_LIST_KEY_0xBBC", Boolean.valueOf(false));
      return;
    }
    QLog.d("ChannelCoverInfoModule", 1, "0xbbcUpChannelList failed.");
  }
  
  public void c(List<oidb_cmd0xbe6.MsgChannelInfo> paramList, int paramInt)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverInfoModule", 2, "saveChannelCoverList, list is empty");
      }
      return;
    }
    ArrayList localArrayList = new ArrayList();
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("saveChannelCoverList channelID=" + paramInt + "\n");; localStringBuilder = null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = qlh.a((oidb_cmd0xbe6.MsgChannelInfo)paramList.next(), paramInt);
        localArrayList.add(localChannelCoverInfo);
        if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
          localStringBuilder.append("[channelCoverId=").append(localChannelCoverInfo.mChannelCoverId).append(", mChannelCoverName=").append(localChannelCoverInfo.mChannelCoverName).append(", mChannelCoverStyle=").append(localChannelCoverInfo.mChannelCoverStyle).append(", mChannelCoverSummary=").append(localChannelCoverInfo.mChannelCoverSummary).append(", mChannelCoverPicUrl=").append(localChannelCoverInfo.mChannelCoverPicUrl).append(", mChannelJumpUrl=").append(localChannelCoverInfo.mChannelJumpUrl).append(", mArticleIds=").append(localChannelCoverInfo.mArticleId).append(", mChannelType=").append(localChannelCoverInfo.mChannelType).append(", isExternalExposure = ").append(localChannelCoverInfo.isExternalExposure).append(", externalExposureIcon : ").append(localChannelCoverInfo.externalExposureBackgroundUrl).append("]\n");
        }
      }
      if ((QLog.isColorLevel()) && (localStringBuilder != null)) {
        QLog.d("ChannelCoverInfoModule", 2, localStringBuilder.toString());
      }
      e(localArrayList, paramInt);
      return;
    }
  }
  
  public List<rcp> d()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  protected void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int m = ((Integer)paramToServiceMsg.getAttribute("req_channellist_source", Integer.valueOf(1))).intValue();
    int i = ((Integer)paramToServiceMsg.getAttribute("req_channellist_channel_id", Integer.valueOf(0))).intValue();
    paramToServiceMsg = new oidb_cmd0x69f.RspBody();
    int j = qlk.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    QLog.d("ChannelCoverInfoModule", 1, "handleGetChannelAndSubscribeList, result=" + j);
    if (j == 0) {
      if (!paramToServiceMsg.uint32_req_channel_id.has()) {
        break label444;
      }
    }
    label444:
    for (i = paramToServiceMsg.uint32_req_channel_id.get();; i = -1)
    {
      int n;
      if (paramToServiceMsg.uint32_channel_seq.has())
      {
        n = paramToServiceMsg.uint32_channel_seq.get();
        int k = a(i);
        j = k;
        if (k == 0)
        {
          j = k;
          if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
          {
            j = k;
            if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
              j = a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, i);
            }
          }
        }
        if (n <= j) {
          QLog.d("ChannelCoverInfoModule", 1, "handleGetChannelAndSubscribeList, seq is " + n + " ;lastseq = " + j + "; not need to update");
        }
      }
      do
      {
        do
        {
          do
          {
            return;
            a(i, n);
            if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) && ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface))) {
              a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, n, i);
            }
            if ((m != 3) || (i != 0)) {
              break;
            }
          } while (!paramToServiceMsg.rpt_channel_list.has());
          b(paramToServiceMsg.rpt_channel_list.get(), 0);
          return;
          if ((m != 4) || (i != 56)) {
            break;
          }
        } while (!paramToServiceMsg.rpt_channel_list.has());
        b(paramToServiceMsg.rpt_channel_list.get(), 56);
        return;
        if (paramToServiceMsg.rpt_channel_list.has())
        {
          b(paramToServiceMsg.rpt_channel_list.get(), i);
          return;
        }
      } while (!QLog.isColorLevel());
      QLog.d("ChannelCoverInfoModule", 2, "handle0x69fGetChannelList resp.rpt_channel_list null , channelId = " + i);
      return;
      if (m == 3) {
        pkp.a().f(false, null);
      }
      for (;;)
      {
        pkp.a().a(i, false, null);
        return;
        if (m == 4) {
          pkp.a().g(false, null);
        }
      }
    }
  }
  
  public void d(List<ChannelCoverInfo> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    Object localObject = paramList.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)((Iterator)localObject).next();
      localLinkedHashMap.put(Integer.valueOf(localChannelCoverInfo.mChannelCoverId), localChannelCoverInfo);
    }
    localObject = this.jdField_a_of_type_JavaLangObject;
    if (paramInt == 0) {}
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaUtilLinkedHashMap.clear();
        this.jdField_a_of_type_JavaUtilLinkedHashMap.putAll(localLinkedHashMap);
        return;
      }
      finally {}
      if (paramInt == 56)
      {
        this.jdField_b_of_type_JavaUtilLinkedHashMap.clear();
        this.jdField_b_of_type_JavaUtilLinkedHashMap.putAll(localLinkedHashMap);
      }
      else if (paramInt == 41402)
      {
        this.jdField_c_of_type_JavaUtilLinkedHashMap.clear();
        this.jdField_c_of_type_JavaUtilLinkedHashMap.putAll(localLinkedHashMap);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilHashMap.remove(Integer.valueOf(paramInt));
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new ArrayList(paramList));
      }
    }
  }
  
  protected void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 1;
    int j = 1;
    paramToServiceMsg = new oidb_cmd0xbe6.RspBody();
    if (qlk.a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0) {
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        if (TextUtils.equals(a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface), paramToServiceMsg.string_channel_version.get())) {
          break label124;
        }
      }
    }
    label124:
    for (i = j;; i = 0)
    {
      a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramToServiceMsg.string_channel_version.get());
      if ((i != 0) && (paramToServiceMsg.msg_get_channel_info_rsp.get() != null) && (paramToServiceMsg.msg_get_channel_info_rsp.rpt_msg_channel_info.get() != null)) {
        c(paramToServiceMsg.msg_get_channel_info_rsp.rpt_msg_channel_info.get(), 41402);
      }
      return;
    }
  }
  
  public void e(List<ChannelCoverInfo> paramList, int paramInt)
  {
    if (paramList == null) {
      return;
    }
    Object localObject = b(paramInt);
    if ((localObject != null) && (paramList != null)) {
      QLog.d("ChannelCoverInfoModule", 1, "saveNewAndRemoveOldChannelCoverInfo removeListSize =" + ((List)localObject).size() + " ;addListSize = " + paramList.size());
    }
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        b(((ChannelCoverInfo)((Iterator)localObject).next()).mChannelCoverId, paramInt);
      }
    }
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      a((ChannelCoverInfo)paramList.next(), paramInt);
    }
    f(b(paramInt), paramInt);
  }
  
  public void f(List<ChannelCoverInfo> paramList, int paramInt)
  {
    d(paramList);
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.post(new ChannelCoverInfoModule.7(this, paramInt, paramList));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     puf
 * JD-Core Version:    0.7.0.1
 */