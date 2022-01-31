import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.UiThread;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
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
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
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

public class pfg
  extends pfi
{
  public final int a;
  private long jdField_a_of_type_Long;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  public final String a;
  private HashMap<Integer, List<ChannelCoverInfo>> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private LinkedHashMap<Integer, ChannelCoverInfo> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private List<qkm> jdField_a_of_type_JavaUtilList;
  private int jdField_b_of_type_Int;
  private HashMap<Integer, Integer> jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private LinkedHashMap<Integer, ChannelCoverInfo> jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private int jdField_c_of_type_Int;
  private LinkedHashMap<Integer, ChannelCoverInfo> jdField_c_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  private int d;
  
  public pfg(AppInterface paramAppInterface, awgf paramawgf, ExecutorService paramExecutorService, puz parampuz, Handler paramHandler)
  {
    super(paramAppInterface, paramawgf, paramExecutorService, parampuz, paramHandler);
    this.jdField_a_of_type_JavaLangString = "UPDATE_CHANNEL_LIST_KEY_0xbbc";
    this.jdField_a_of_type_Int = 3;
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "construct!");
    }
  }
  
  public static int a()
  {
    return Aladdin.getConfig(220).getIntegerFromString("main_feeds_channel_id", -1);
  }
  
  private int a(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_b_of_type_Int;
    }
    if (paramInt == 56) {
      return this.jdField_c_of_type_Int;
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
  
  public static String a()
  {
    return Aladdin.getConfig(220).getString("main_feeds_channel_name", "");
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
      this.jdField_b_of_type_Int = paramInt2;
      return;
    }
    if (paramInt1 == 56)
    {
      this.jdField_c_of_type_Int = paramInt2;
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
        break label104;
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
      label104:
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
  
  private void a(List<qkm> paramList1, List<qkm> paramList2)
  {
    SparseArray localSparseArray = new SparseArray();
    paramList2 = paramList2.iterator();
    Object localObject1;
    Object localObject2;
    while (paramList2.hasNext())
    {
      localObject1 = ((qkm)paramList2.next()).jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TabChannelCoverInfo)((Iterator)localObject1).next();
        localSparseArray.put(((TabChannelCoverInfo)localObject2).mChannelCoverId, localObject2);
      }
    }
    paramList2 = paramList1.iterator();
    if (paramList2.hasNext())
    {
      localObject1 = (qkm)paramList2.next();
      localObject2 = ((qkm)localObject1).jdField_a_of_type_JavaUtilList.iterator();
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
          if (!otb.a()) {
            break label285;
          }
          i = 11;
          label214:
          if ((paramList1.indexOf(localObject1) != 0) || (((qkm)localObject1).jdField_a_of_type_JavaUtilList.indexOf(localTabChannelCoverInfo1) >= i)) {
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
    if (this.d < 3)
    {
      this.d += 1;
      return true;
    }
    this.d = 0;
    bkbq.a("UPDATE_CHANNEL_LIST_KEY_0xbbc", Boolean.valueOf(false));
    return false;
  }
  
  public static boolean a(int paramInt)
  {
    if (!((Boolean)bkbq.a("sp_key_channel_list_dynamic_order_switch", Boolean.valueOf(false))).booleanValue())
    {
      QLog.d("ChannelCoverInfoModule", 1, "isSupportChannelDynamicOrder, switch is off.");
      return false;
    }
    Object localObject1 = (QQAppInterface)ors.a();
    if (localObject1 != null)
    {
      localObject1 = (oxd)((QQAppInterface)localObject1).getManager(163);
      if (localObject1 != null)
      {
        localObject1 = ((oxd)localObject1).a().a();
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
                localObject2 = ((qkm)((Iterator)localObject1).next()).jdField_a_of_type_JavaUtilList;
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
  
  private List<TabChannelCoverInfo> b(List<qkm> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    int i = 0;
    if (paramList.hasNext())
    {
      qkm localqkm = (qkm)paramList.next();
      if ((localqkm.jdField_a_of_type_JavaUtilList == null) || (localqkm.jdField_a_of_type_JavaUtilList.isEmpty())) {
        break label129;
      }
      Iterator localIterator = localqkm.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)localIterator.next();
        localTabChannelCoverInfo.channelConfigType = localqkm.jdField_a_of_type_Long;
        localTabChannelCoverInfo.seq = i;
        localArrayList.add(localTabChannelCoverInfo);
        i += 1;
      }
    }
    label129:
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
      if (QLog.isColorLevel()) {
        QLog.i("ChannelCoverInfoModule", 2, "removeChannelCoverInfoFromDBAndCache channelID=" + paramInt2 + " ;channelCoverId = " + paramInt1);
      }
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
      oxb.a().e(paramBoolean, paramList);
    }
    while (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.post(new ChannelCoverInfoModule.6(this, paramBoolean, paramList));
  }
  
  private List<qkm> c(List<qkm> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      int i = 0;
      while (paramList.hasNext())
      {
        Object localObject = (qkm)paramList.next();
        qkm localqkm = new qkm(((qkm)localObject).jdField_a_of_type_Long, ((qkm)localObject).jdField_a_of_type_JavaLangString, ((qkm)localObject).b);
        localObject = ((qkm)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (((Iterator)localObject).hasNext())
        {
          TabChannelCoverInfo localTabChannelCoverInfo1 = (TabChannelCoverInfo)((Iterator)localObject).next();
          TabChannelCoverInfo localTabChannelCoverInfo2 = localTabChannelCoverInfo1.clone();
          localTabChannelCoverInfo2.channelConfigType = localTabChannelCoverInfo1.channelConfigType;
          localTabChannelCoverInfo2.seq = i;
          localqkm.jdField_a_of_type_JavaUtilList.add(localTabChannelCoverInfo2);
          i += 1;
        }
        localArrayList.add(localqkm);
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
    Object localObject3 = null;
    Object localObject4 = null;
    boolean bool2 = true;
    boolean bool1 = true;
    paramList = (List<TabChannelCoverInfo>)localObject1;
    if (localIterator.hasNext())
    {
      localObject1 = (TabChannelCoverInfo)localIterator.next();
      if (((TabChannelCoverInfo)localObject1).mChannelCoverId == 0)
      {
        localObject4 = localObject1;
        bool2 = false;
      }
      if (((TabChannelCoverInfo)localObject1).mChannelCoverId == 70)
      {
        localObject3 = localObject1;
        bool1 = false;
      }
      if (((TabChannelCoverInfo)localObject1).mChannelCoverId != a()) {
        break label285;
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
      if (a() != -1)
      {
        i = a();
        if (TextUtils.isEmpty(a())) {
          break label275;
        }
      }
      label275:
      for (paramList = a();; paramList = alud.a(2131701897))
      {
        if (!bool2) {
          ((List)localObject2).remove(localObject4);
        }
        ((List)localObject2).add(0, new TabChannelCoverInfo(i, paramList, 4, "https://p.qpic.cn/kandianac/0/9558fc75932c5.png/0"));
        if (!bool1) {
          ((List)localObject2).remove(localObject3);
        }
        ((List)localObject2).add(0, new TabChannelCoverInfo(70, alud.a(2131701920), 4, "https://p.qpic.cn/kandianac/0/993c416b9d2b9.png/0"));
        QLog.d("ChannelCoverInfoModule", 1, new Object[] { "forceInsertChannelList insertRecommendChannel = ", Boolean.valueOf(bool2), ", insertFollowChannel = ", Boolean.valueOf(bool1) });
        return localObject2;
        i = 0;
        break;
      }
      label285:
      localObject1 = paramList;
    }
  }
  
  private List<ChannelCoverInfo> e(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "loadFromDb with selection=" + "mChannelID = ?" + ", channelId=" + paramInt);
    }
    return this.jdField_a_of_type_Awgf.a(ChannelCoverInfo.class, true, "mChannelID = ?", new String[] { String.valueOf(paramInt) }, null, null, null, null);
  }
  
  private void f()
  {
    for (;;)
    {
      try
      {
        localReqBody = new oidb_cmd0xbe6.ReqBody();
        localPhoneInfo = new oidb_cmd0xbe6.PhoneInfo();
        str = ors.f();
        if (!TextUtils.isEmpty(str))
        {
          str = bflr.d(str.toLowerCase()).toLowerCase();
          localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(str));
          localPhoneInfo.uint32_muid_type.set(1);
          i = nmh.a();
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
        QLog.e("ChannelCoverInfoModule", 2, "requestWeiShiChannelCoverListFromServer failed for param error:" + ors.a(localThrowable));
        return;
      }
      try
      {
        j = bdgk.e();
        i = j;
      }
      catch (Exception localException)
      {
        continue;
      }
      localPhoneInfo.uint32_carrier.set(i);
      str = bdgk.e();
      localPhoneInfo.bytes_os_ver.set(ByteStringMicro.copyFromUtf8(str));
      str = bdgk.c();
      localPhoneInfo.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8(str));
      i = AppSetting.a();
      localPhoneInfo.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
      str = dr.a(dr.a());
      localPhoneInfo.bytes_client_ip.set(ByteStringMicro.copyFromUtf8(str));
      localPhoneInfo.uint32_os_type.set(2);
      localReqBody.msg_phone_info.set(localPhoneInfo, true);
      if ((this.jdField_a_of_type_ComTencentCommonAppAppInterface instanceof QQAppInterface)) {
        localReqBody.string_channel_version.set(a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface));
      }
      a(pvb.a("OidbSvc.0xbe6", 3046, 1, localReqBody.toByteArray()));
      return;
      str = bdgk.c(BaseApplication.getContext());
      if (!TextUtils.isEmpty(str))
      {
        str = bflr.d(str.replaceAll(":", "").toUpperCase()).toLowerCase();
        localPhoneInfo.bytes_muid.set(ByteStringMicro.copyFromUtf8(str));
        localPhoneInfo.uint32_muid_type.set(3);
      }
    }
  }
  
  private void g(List<qkm> paramList)
  {
    if (paramList != null) {
      try
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          Object localObject = (qkm)paramList.next();
          if (localObject != null)
          {
            localObject = ((qkm)localObject).jdField_a_of_type_JavaUtilList;
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
    localArrayList.add(new TabChannelCoverInfo(51, alud.a(2131701926)));
    localArrayList.add(new TabChannelCoverInfo(58, alud.a(2131701913)));
    localArrayList.add(new TabChannelCoverInfo(59, alud.a(2131701912)));
    localArrayList.add(new TabChannelCoverInfo(10, alud.a(2131701915)));
    localArrayList.add(new TabChannelCoverInfo(52, alud.a(2131701928)));
    localArrayList.add(new TabChannelCoverInfo(53, alud.a(2131701909)));
    localArrayList.add(new TabChannelCoverInfo(9, alud.a(2131701919)));
    localArrayList.add(new TabChannelCoverInfo(54, alud.a(2131701904)));
    localArrayList.add(new TabChannelCoverInfo(55, alud.a(2131701906)));
    localArrayList.add(new TabChannelCoverInfo(40007, alud.a(2131701908)));
    return localArrayList;
  }
  
  private List<TabChannelCoverInfo> l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "loadFromDb");
    }
    return this.jdField_a_of_type_Awgf.a(TabChannelCoverInfo.class);
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
    //   3: getfield 413	pfg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: ifnull +36 -> 42
    //   9: aload_0
    //   10: getfield 413	pfg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   13: invokeinterface 406 1 0
    //   18: ifne +24 -> 42
    //   21: aload_0
    //   22: getfield 413	pfg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   25: iconst_0
    //   26: invokeinterface 255 2 0
    //   31: checkcast 268	qkm
    //   34: getfield 270	qkm:jdField_a_of_type_JavaUtilList	Ljava/util/List;
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
    //   0	52	0	this	pfg
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
    //   3: getfield 413	pfg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   6: ifnull +24 -> 30
    //   9: aload_0
    //   10: getfield 413	pfg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   13: iload_1
    //   14: invokeinterface 255 2 0
    //   19: checkcast 268	qkm
    //   22: getfield 270	qkm:jdField_a_of_type_JavaUtilList	Ljava/util/List;
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
    //   0	40	0	this	pfg
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
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        if (a(paramTabChannelCoverInfo, ((qkm)((Iterator)localObject).next()).jdField_a_of_type_JavaUtilList)) {
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
    JSONArray localJSONArray;
    try
    {
      List localList = this.jdField_a_of_type_JavaUtilList;
      this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList.size());
      localJSONArray = new JSONArray();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        channel_button.Section localSection = (channel_button.Section)paramList.next();
        qkm localqkm = new qkm(localSection);
        localJSONArray.put(localqkm.a());
        localqkm.jdField_a_of_type_JavaUtilList = puy.b(localSection.rpt_msg_channel.get());
        this.jdField_a_of_type_JavaUtilList.add(localqkm);
      }
      a(this.jdField_a_of_type_JavaUtilList, localList);
    }
    finally {}
    c(this.jdField_a_of_type_JavaUtilList);
    a(this.jdField_a_of_type_JavaUtilList, true);
    if (localJSONArray.length() > 0) {
      ThreadManager.executeOnFileThread(new ChannelCoverInfoModule.10(this, localJSONArray));
    }
  }
  
  public void a(List<qkm> paramList, int paramInt)
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
        localObject2 = (qkm)((Iterator)localObject1).next();
        a(((qkm)localObject2).jdField_a_of_type_JavaUtilList, "0xbbc update sectionId=" + ((qkm)localObject2).jdField_a_of_type_Long);
      }
    }
    Object localObject1 = new oidb_cmd0xbbc.ReqBody();
    Object localObject2 = new ArrayList();
    Iterator localIterator1 = paramList.iterator();
    while (localIterator1.hasNext())
    {
      qkm localqkm = (qkm)localIterator1.next();
      channel_button.Section localSection = new channel_button.Section();
      ArrayList localArrayList = new ArrayList();
      if (localqkm.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator2 = localqkm.jdField_a_of_type_JavaUtilList.iterator();
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
        localSection.uint64_section_id.set(localqkm.jdField_a_of_type_Long);
        localSection.str_section_name.set(localqkm.jdField_a_of_type_JavaLangString);
        localSection.str_note_text.set(localqkm.b);
        localSection.rpt_msg_channel.set(localArrayList);
        ((List)localObject2).add(localSection);
      }
    }
    ((oidb_cmd0xbbc.ReqBody)localObject1).rpt_msg_section.set((List)localObject2);
    paramList = new oidb_cmd0xbbc.PhoneInfo();
    localObject2 = ors.f();
    if (!TextUtils.isEmpty((CharSequence)localObject2))
    {
      localObject2 = bflr.d(((String)localObject2).toLowerCase()).toLowerCase();
      paramList.bytes_muid.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      paramList.uint32_muid_type.set(1);
    }
    for (;;)
    {
      int i = nmh.a();
      paramList.uint32_conn.set(i);
      i = 0;
      try
      {
        int j = bdgk.e();
        i = j;
      }
      catch (Exception localException)
      {
        label449:
        break label449;
      }
      paramList.uint32_carrier.set(i);
      localObject2 = bdgk.e();
      paramList.bytes_os_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      localObject2 = bdgk.c();
      paramList.bytes_qq_ver.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      i = AppSetting.a();
      paramList.bytes_appid.set(ByteStringMicro.copyFromUtf8(String.valueOf(i)));
      localObject2 = dr.a(dr.a());
      paramList.bytes_client_ip.set(ByteStringMicro.copyFromUtf8((String)localObject2));
      paramList.uint32_os_type.set(2);
      ((oidb_cmd0xbbc.ReqBody)localObject1).msg_phone_type.set(paramList, true);
      ((oidb_cmd0xbbc.ReqBody)localObject1).uint32_set_type.set(paramInt);
      a(pvb.a("OidbSvc.0xbbc", 3004, 1, ((oidb_cmd0xbbc.ReqBody)localObject1).toByteArray()));
      bkbq.a("UPDATE_CHANNEL_LIST_KEY_0xbbc", Boolean.valueOf(true));
      return;
      localObject2 = bdgk.c(BaseApplication.getContext());
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject2 = bflr.d(((String)localObject2).replaceAll(":", "").toUpperCase()).toLowerCase();
        paramList.bytes_muid.set(ByteStringMicro.copyFromUtf8((String)localObject2));
        paramList.uint32_muid_type.set(3);
      }
    }
  }
  
  public void a(List<qkm> paramList, boolean paramBoolean)
  {
    List localList;
    try
    {
      localList = b(this.jdField_a_of_type_JavaUtilList);
      ((qkm)paramList.get(0)).jdField_a_of_type_JavaUtilList = d(((qkm)paramList.get(0)).jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_JavaUtilList = c(paramList);
      paramList = b(this.jdField_a_of_type_JavaUtilList);
      if (paramBoolean) {
        b(true, ((qkm)this.jdField_a_of_type_JavaUtilList.get(0)).jdField_a_of_type_JavaUtilList);
      }
      if (!QLog.isColorLevel()) {
        break label193;
      }
      QLog.i("ChannelCoverInfoModule", 2, "saveChannelInfoListInCacheAndDb remove oldList");
      localIterator = localList.iterator();
      while (localIterator.hasNext()) {
        QLog.i("ChannelCoverInfoModule", 2, ((TabChannelCoverInfo)localIterator.next()).toString());
      }
      QLog.i("ChannelCoverInfoModule", 2, "saveChannelInfoListInCacheAndDb save newList");
    }
    finally {}
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      QLog.i("ChannelCoverInfoModule", 2, ((TabChannelCoverInfo)localIterator.next()).toString());
    }
    label193:
    this.jdField_a_of_type_JavaUtilConcurrentExecutorService.execute(new ChannelCoverInfoModule.9(this, localList, paramList));
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
    localArrayList.add(new TabChannelCoverInfo(70, alud.a(2131701911), 4, "https://p.qpic.cn/kandianac/0/993c416b9d2b9.png/0"));
    localArrayList.add(new TabChannelCoverInfo(0, alud.a(2131701910), 4, "https://p.qpic.cn/kandianac/0/9558fc75932c5.png/0"));
    TabChannelCoverInfo localTabChannelCoverInfo = new TabChannelCoverInfo(56, alud.a(2131701921));
    localTabChannelCoverInfo.reason = 4;
    localTabChannelCoverInfo.mChannelType = 3;
    localArrayList.add(localTabChannelCoverInfo);
    localArrayList.add(new TabChannelCoverInfo(40531, alud.a(2131701923)));
    localArrayList.add(new TabChannelCoverInfo(14, alud.a(2131701907)));
    localArrayList.add(new TabChannelCoverInfo(8, alud.a(2131701925)));
    localArrayList.add(new TabChannelCoverInfo(1, alud.a(2131701914)));
    localArrayList.add(new TabChannelCoverInfo(13, alud.a(2131701900)));
    localArrayList.add(new TabChannelCoverInfo(5, alud.a(2131701930)));
    localArrayList.add(new TabChannelCoverInfo(11, alud.a(2131701899)));
    localArrayList.add(new TabChannelCoverInfo(40466, alud.a(2131701924)));
    localArrayList.add(new TabChannelCoverInfo(40013, alud.a(2131701922)));
    localArrayList.add(new TabChannelCoverInfo(16, alud.a(2131701917)));
    localArrayList.add(new TabChannelCoverInfo(15, alud.a(2131701903)));
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
    //   0: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 60
    //   8: iconst_2
    //   9: ldc_w 953
    //   12: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: ldc 48
    //   17: iconst_0
    //   18: invokestatic 317	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   21: invokestatic 328	bkbq:a	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   24: checkcast 314	java/lang/Boolean
    //   27: invokevirtual 331	java/lang/Boolean:booleanValue	()Z
    //   30: ifeq +29 -> 59
    //   33: aload_0
    //   34: invokespecial 954	pfg:a	()Z
    //   37: ifeq +22 -> 59
    //   40: ldc 60
    //   42: iconst_2
    //   43: ldc_w 956
    //   46: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: aload_0
    //   51: getfield 413	pfg:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   54: iconst_3
    //   55: invokevirtual 958	pfg:a	(Ljava/util/List;I)V
    //   58: return
    //   59: getstatic 961	nwm:a	Z
    //   62: ifeq +13 -> 75
    //   65: ldc 60
    //   67: iconst_2
    //   68: ldc_w 963
    //   71: invokestatic 65	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   74: return
    //   75: invokestatic 968	java/lang/System:currentTimeMillis	()J
    //   78: ldc2_w 969
    //   81: ldiv
    //   82: aload_0
    //   83: getfield 971	pfg:jdField_a_of_type_Long	J
    //   86: lcmp
    //   87: iflt -29 -> 58
    //   90: new 973	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody
    //   93: dup
    //   94: invokespecial 974	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:<init>	()V
    //   97: astore_2
    //   98: aload_2
    //   99: getfield 977	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:bytes_city	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   102: invokestatic 980	ampk:a	()Ljava/lang/String;
    //   105: invokestatic 554	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   108: invokevirtual 559	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   111: aload_2
    //   112: getfield 983	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:str_city	Lcom/tencent/mobileqq/pb/PBStringField;
    //   115: invokestatic 985	ampk:b	()Ljava/lang/String;
    //   118: invokevirtual 633	com/tencent/mobileqq/pb/PBStringField:set	(Ljava/lang/String;)V
    //   121: aload_0
    //   122: getfield 621	pfg:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   125: checkcast 106	com/tencent/mobileqq/app/QQAppInterface
    //   128: bipush 51
    //   130: invokevirtual 342	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   133: checkcast 987	alto
    //   136: aload_0
    //   137: getfield 621	pfg:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   140: checkcast 106	com/tencent/mobileqq/app/QQAppInterface
    //   143: invokevirtual 988	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   146: invokevirtual 991	alto:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   149: astore_3
    //   150: aload_3
    //   151: ifnull +25 -> 176
    //   154: aload_2
    //   155: getfield 994	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:uint32_age	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   158: aload_3
    //   159: getfield 999	com/tencent/mobileqq/data/Friends:age	I
    //   162: invokevirtual 568	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   165: aload_2
    //   166: getfield 1002	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:uint32_sex	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   169: aload_3
    //   170: getfield 1006	com/tencent/mobileqq/data/Friends:gender	B
    //   173: invokevirtual 568	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   176: new 1008	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo
    //   179: dup
    //   180: invokespecial 1009	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:<init>	()V
    //   183: astore_3
    //   184: invokestatic 536	ors:f	()Ljava/lang/String;
    //   187: astore 4
    //   189: aload 4
    //   191: invokestatic 485	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   194: ifne +329 -> 523
    //   197: aload 4
    //   199: invokevirtual 539	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   202: astore 4
    //   204: aload 4
    //   206: invokestatic 544	bflr:d	(Ljava/lang/String;)Ljava/lang/String;
    //   209: invokevirtual 539	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   212: astore 4
    //   214: aload_3
    //   215: getfield 1010	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_muid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   218: aload 4
    //   220: invokestatic 554	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   223: invokevirtual 559	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   226: aload_3
    //   227: getfield 1011	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_muid_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   230: iconst_1
    //   231: invokevirtual 568	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   234: invokestatic 571	nmh:a	()I
    //   237: istore_1
    //   238: aload_3
    //   239: getfield 1012	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_conn	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   242: iload_1
    //   243: invokevirtual 568	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   246: invokestatic 578	bdgk:e	()I
    //   249: istore_1
    //   250: aload_3
    //   251: getfield 1013	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_carrier	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   254: iload_1
    //   255: invokevirtual 568	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   258: invokestatic 583	bdgk:e	()Ljava/lang/String;
    //   261: astore 4
    //   263: aload_3
    //   264: getfield 1014	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_os_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   267: aload 4
    //   269: invokestatic 554	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   272: invokevirtual 559	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   275: invokestatic 588	bdgk:c	()Ljava/lang/String;
    //   278: astore 4
    //   280: aload_3
    //   281: getfield 1015	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_qq_ver	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   284: aload 4
    //   286: invokestatic 554	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   289: invokevirtual 559	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   292: invokestatic 594	com/tencent/common/config/AppSetting:a	()I
    //   295: istore_1
    //   296: aload_3
    //   297: getfield 1016	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_appid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   300: iload_1
    //   301: invokestatic 519	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   304: invokestatic 554	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   307: invokevirtual 559	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   310: invokestatic 602	dr:a	()J
    //   313: invokestatic 605	dr:a	(J)Ljava/lang/String;
    //   316: astore 4
    //   318: aload_3
    //   319: getfield 1017	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_client_ip	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   322: aload 4
    //   324: invokestatic 554	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   327: invokevirtual 559	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   330: aload_3
    //   331: getfield 1018	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_os_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   334: iconst_2
    //   335: invokevirtual 568	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   338: aload_2
    //   339: getfield 1021	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:msg_phone_type	Ltencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo;
    //   342: aload_3
    //   343: iconst_1
    //   344: invokevirtual 1022	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;Z)V
    //   347: invokestatic 1023	owy:a	()Lowy;
    //   350: invokevirtual 1026	owy:a	()Lcom/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule;
    //   353: astore_3
    //   354: aload_3
    //   355: ifnull +132 -> 487
    //   358: aload_3
    //   359: invokevirtual 1031	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule:a	()Lcom/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData;
    //   362: astore_3
    //   363: invokestatic 58	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq +29 -> 395
    //   369: ldc 60
    //   371: iconst_2
    //   372: new 112	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   379: ldc_w 1033
    //   382: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: aload_3
    //   386: invokevirtual 1036	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   389: invokevirtual 126	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 422	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: aload_3
    //   396: ifnull +91 -> 487
    //   399: aload_3
    //   400: getfield 1041	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:city	Ljava/lang/String;
    //   403: invokestatic 485	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   406: ifne +81 -> 487
    //   409: new 1043	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo
    //   412: dup
    //   413: invokespecial 1044	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:<init>	()V
    //   416: astore 4
    //   418: aload 4
    //   420: getfield 1045	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:bytes_city	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   423: aload_3
    //   424: getfield 1041	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:city	Ljava/lang/String;
    //   427: invokestatic 554	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   430: invokevirtual 559	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   433: aload 4
    //   435: getfield 1048	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:bytes_province	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   438: aload_3
    //   439: getfield 1051	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:province	Ljava/lang/String;
    //   442: invokestatic 554	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   445: invokevirtual 559	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   448: aload 4
    //   450: getfield 1054	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:bytes_country	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   453: aload_3
    //   454: getfield 1057	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:country	Ljava/lang/String;
    //   457: invokestatic 554	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   460: invokevirtual 559	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   463: aload 4
    //   465: getfield 1060	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:bytes_city_code	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   468: aload_3
    //   469: getfield 1063	com/tencent/biz/pubaccount/readinjoy/model/SelectPositionModule$PositionData:cityCode	Ljava/lang/String;
    //   472: invokestatic 554	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   475: invokevirtual 559	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   478: aload_2
    //   479: getfield 1067	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:msg_location_info	Ltencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo;
    //   482: aload 4
    //   484: invokevirtual 1070	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$LocationInfo:set	(Lcom/tencent/mobileqq/pb/MessageMicro;)V
    //   487: aload_0
    //   488: ldc_w 1072
    //   491: sipush 3003
    //   494: iconst_1
    //   495: aload_2
    //   496: invokevirtual 1073	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$ReqBody:toByteArray	()[B
    //   499: invokestatic 644	pvb:a	(Ljava/lang/String;II[B)Lcom/tencent/qphone/base/remote/ToServiceMsg;
    //   502: invokevirtual 647	pfg:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;)V
    //   505: return
    //   506: astore 4
    //   508: aload_3
    //   509: getfield 1010	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_muid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   512: ldc 181
    //   514: invokestatic 554	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   517: invokevirtual 559	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   520: goto -294 -> 226
    //   523: invokestatic 653	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   526: invokestatic 656	bdgk:c	(Landroid/content/Context;)Ljava/lang/String;
    //   529: astore 4
    //   531: aload 4
    //   533: invokestatic 485	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   536: ifne -302 -> 234
    //   539: aload 4
    //   541: ldc_w 658
    //   544: ldc 181
    //   546: invokevirtual 661	java/lang/String:replaceAll	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   549: invokevirtual 664	java/lang/String:toUpperCase	()Ljava/lang/String;
    //   552: invokestatic 544	bflr:d	(Ljava/lang/String;)Ljava/lang/String;
    //   555: invokevirtual 539	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   558: astore 4
    //   560: aload_3
    //   561: getfield 1010	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:bytes_muid	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   564: aload 4
    //   566: invokestatic 554	com/tencent/mobileqq/pb/ByteStringMicro:copyFromUtf8	(Ljava/lang/String;)Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   569: invokevirtual 559	com/tencent/mobileqq/pb/PBBytesField:set	(Lcom/tencent/mobileqq/pb/ByteStringMicro;)V
    //   572: aload_3
    //   573: getfield 1011	tencent/im/oidb/cmd0xbbb/oidb_cmd0xbbb$PhoneInfo:uint32_muid_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   576: iconst_3
    //   577: invokevirtual 568	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   580: goto -346 -> 234
    //   583: astore 4
    //   585: iconst_0
    //   586: istore_1
    //   587: goto -337 -> 250
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	590	0	this	pfg
    //   237	350	1	i	int
    //   97	399	2	localReqBody	tencent.im.oidb.cmd0xbbb.oidb_cmd0xbbb.ReqBody
    //   149	424	3	localObject1	Object
    //   187	296	4	localObject2	Object
    //   506	1	4	localException1	Exception
    //   529	36	4	str	String
    //   583	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   204	226	506	java/lang/Exception
    //   246	250	583	java/lang/Exception
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "requestChannelCoverListFromServer");
    }
    if (paramInt == 41402)
    {
      f();
      return;
    }
    Object localObject = new oidb_cmd0x69f.ReqBody();
    long l = Long.valueOf(ors.a()).longValue();
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
      localObject = pvb.a("OidbSvc.0x69f", 1695, 0, ((oidb_cmd0x69f.ReqBody)localObject).toByteArray());
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
    int i = pvb.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
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
        ChannelCoverInfo localChannelCoverInfo1 = puy.a((oidb_cmd0x69f.ChannelInfo)paramList.next(), paramInt);
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
  
  public List<qkm> c()
  {
    int i = 0;
    try
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = bdhb.a(new File(BaseApplicationImpl.getApplication().getDir("readinjoy", 0).getAbsolutePath() + "/channel_section_data"));
      if (localObject2 != null) {
        try
        {
          localObject2 = new JSONArray((String)localObject2);
          while (i < ((JSONArray)localObject2).length())
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).optJSONObject(i);
            if (localJSONObject != null) {
              localArrayList.add(new qkm(localJSONObject));
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
        this.jdField_a_of_type_JavaUtilList.add(new qkm(TabChannelCoverInfo.TYPE_CHANNEL_MY_CONFIG, alud.a(2131701898), alud.a(2131701902)));
        this.jdField_a_of_type_JavaUtilList.add(new qkm(TabChannelCoverInfo.TYPE_CHANNEL_RECOMMEND_CONFIG, alud.a(2131701905), alud.a(2131701916)));
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
    int i = pvb.a(paramFromServiceMsg, paramObject, new oidb_cmd0xbbc.RspBody());
    QLog.d("ChannelCoverInfoModule", 1, new Object[] { "handleOxbbcUpChannelList, result = ", Integer.valueOf(i) });
    if (i == 0)
    {
      bkbq.a("UPDATE_CHANNEL_LIST_KEY_0xbbc", Boolean.valueOf(false));
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
        ChannelCoverInfo localChannelCoverInfo = puy.a((oidb_cmd0xbe6.MsgChannelInfo)paramList.next(), paramInt);
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
  
  public List<qkm> d()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  protected void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int m = ((Integer)paramToServiceMsg.getAttribute("req_channellist_source", Integer.valueOf(1))).intValue();
    int i = ((Integer)paramToServiceMsg.getAttribute("req_channellist_channel_id", Integer.valueOf(0))).intValue();
    paramToServiceMsg = new oidb_cmd0x69f.RspBody();
    int j = pvb.a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("ChannelCoverInfoModule", 2, "handleGetChannelAndSubscribeList, result=" + j);
    }
    if (j == 0) {
      if (!paramToServiceMsg.uint32_req_channel_id.has()) {
        break label456;
      }
    }
    label456:
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
          if (QLog.isColorLevel()) {
            QLog.d("ChannelCoverInfoModule", 2, "handleGetChannelAndSubscribeList, seq is " + n + " ;lastseq = " + j + "; not need to update");
          }
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
        oxb.a().f(false, null);
      }
      for (;;)
      {
        oxb.a().a(i, false, null);
        return;
        if (m == 4) {
          oxb.a().g(false, null);
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
    if (pvb.a(paramFromServiceMsg, paramObject, paramToServiceMsg) == 0) {
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
    if ((localObject != null) && (paramList != null) && (QLog.isColorLevel())) {
      QLog.d("ChannelCoverInfoModule", 2, "saveNewAndRemoveOldChannelCoverInfo removeListSize =" + ((List)localObject).size() + " ;addListSize = " + paramList.size());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pfg
 * JD-Core Version:    0.7.0.1
 */