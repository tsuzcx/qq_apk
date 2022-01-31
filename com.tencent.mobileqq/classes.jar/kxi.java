import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.av.AVFunChat.AVFunChatMessage;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.magicface.FaceItem;
import com.tencent.av.business.manager.magicface.MagicFaceDataEntity;
import com.tencent.av.business.manager.pendant.PendantItem;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.TimeZone;
import java.util.concurrent.ArrayBlockingQueue;
import org.json.JSONArray;
import org.json.JSONObject;

public class kxi
  extends EffectConfigBase<FaceItem>
  implements kxe, kxr
{
  public static final String e = jdField_b_of_type_JavaLangString + 176 + File.separator;
  private MagicFaceDataEntity jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Queue<MagicFaceDataEntity> jdField_a_of_type_JavaUtilQueue = new ArrayBlockingQueue(8);
  kxk jdField_a_of_type_Kxk = new kxk();
  private kxs jdField_a_of_type_Kxs;
  private kxv jdField_a_of_type_Kxv = new kxv();
  private kyo jdField_a_of_type_Kyo;
  private boolean jdField_a_of_type_Boolean;
  private ArrayList<kxj> b;
  private String f;
  private String g;
  
  public kxi(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private MagicFaceDataEntity a(FaceItem paramFaceItem, String paramString, boolean paramBoolean, int paramInt)
  {
    String str1 = null;
    String str2;
    if (paramFaceItem != null)
    {
      krx.c(this.jdField_a_of_type_JavaLangString, String.format("createMagicEntity: id=%s, senderType%s.", new Object[] { paramFaceItem.getId(), Integer.valueOf(paramInt) }));
      str1 = paramFaceItem.getId();
      str2 = paramFaceItem.getType();
      if (!"multi_result".equalsIgnoreCase(paramFaceItem.getAttr())) {
        break label100;
      }
      paramString = new kxp(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str1, str2, paramString, paramBoolean, paramInt);
    }
    for (;;)
    {
      paramFaceItem.lastPositionIndex = paramString.a(paramFaceItem.lastPositionIndex);
      str1 = paramString;
      return str1;
      label100:
      if ("huanlian".equalsIgnoreCase(paramFaceItem.getAttr())) {
        paramString = new lpl(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str1, str2, paramString, paramBoolean, paramInt);
      } else {
        paramString = new MagicFaceDataEntity(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str1, str2, paramString, paramBoolean, paramInt);
      }
    }
  }
  
  private MagicFaceDataEntity a(String paramString, boolean paramBoolean)
  {
    boolean bool = false;
    int i = 1;
    paramString = (FaceItem)a(paramString);
    if (paramString != null)
    {
      Object localObject = b(paramString);
      localObject = new File((String)localObject + "config.json");
      if (((File)localObject).exists())
      {
        localObject = bace.a((File)localObject);
        if (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().e) {
          bool = true;
        }
        if (paramBoolean) {}
        for (;;)
        {
          return a(paramString, (String)localObject, bool, i);
          i = 2;
        }
      }
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add("config.json");
      this.jdField_a_of_type_Kwx.a(paramString, a(paramString), b(paramString), localArrayList, false);
      krx.e(this.jdField_a_of_type_JavaLangString, "prepareEntity FILE not exist: " + ((File)localObject).getPath());
    }
    return null;
  }
  
  private void a(long paramLong, MagicFaceDataEntity paramMagicFaceDataEntity, kxs paramkxs)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity = paramMagicFaceDataEntity;
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity != null)
    {
      FaceItem localFaceItem = (FaceItem)a(paramMagicFaceDataEntity.b());
      if (localFaceItem != null)
      {
        String str = b(localFaceItem);
        if (!TextUtils.isEmpty(str))
        {
          if ((localFaceItem.isSameType("voicesticker")) || (localFaceItem.isSameType("face"))) {
            lja.a().a(2);
          }
          this.jdField_a_of_type_Kxv.a(paramLong, str, paramMagicFaceDataEntity, paramkxs, this);
        }
      }
    }
  }
  
  private boolean a(long paramLong)
  {
    if (this.jdField_a_of_type_JavaUtilQueue.size() > 0)
    {
      MagicFaceDataEntity localMagicFaceDataEntity = (MagicFaceDataEntity)this.jdField_a_of_type_JavaUtilQueue.remove();
      if (AudioHelper.e()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "playItemFromQueueHead, id[" + localMagicFaceDataEntity + "], seq[" + paramLong + "]");
      }
      a(paramLong, localMagicFaceDataEntity, this.jdField_a_of_type_Kxs);
      a(paramLong, localMagicFaceDataEntity.b());
      if (localMagicFaceDataEntity.c())
      {
        a(paramLong, 6102, null, null);
        this.f = null;
      }
      return true;
    }
    return false;
  }
  
  private int b()
  {
    int j = 0;
    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    kvq localkvq = localVideoController.a();
    int i = localVideoController.b(localkvq.d);
    if ((i == 2) || (i == 3) || (i == 4))
    {
      i = 1;
      if (i != 0) {
        break label59;
      }
      i = 1;
    }
    label59:
    int k;
    do
    {
      return i;
      i = 0;
      break;
      k = localVideoController.c(localkvq.d);
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "checkPeerCreativeSupport peerSharpVersion:=" + k);
      }
      i = j;
    } while (k > 105);
    return 2;
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "sendStartCreativeCopMsg, id[" + paramString + "]");
    }
    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    AVFunChat.AVFunChatMessage localAVFunChatMessage = new AVFunChat.AVFunChatMessage();
    localAVFunChatMessage.uint64_type.set(14L);
    localAVFunChatMessage.enum_operator.set(1);
    PBStringField localPBStringField = localAVFunChatMessage.str_msg;
    String str = paramString;
    if (paramString == null) {
      str = "0";
    }
    localPBStringField.set(str);
    localVideoController.a(14, localAVFunChatMessage);
  }
  
  private void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.jdField_a_of_type_JavaLangString, 2, "sendStopCreativeCopMsg, id[" + paramString + "]");
    }
    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    AVFunChat.AVFunChatMessage localAVFunChatMessage = new AVFunChat.AVFunChatMessage();
    localAVFunChatMessage.uint64_type.set(14L);
    localAVFunChatMessage.enum_operator.set(0);
    PBStringField localPBStringField = localAVFunChatMessage.str_msg;
    String str = paramString;
    if (paramString == null) {
      str = "0";
    }
    localPBStringField.set(str);
    localVideoController.a(14, localAVFunChatMessage);
  }
  
  private void d(String paramString)
  {
    paramString = (FaceItem)a(paramString);
    int i;
    if (paramString != null)
    {
      if (!paramString.isInteract()) {
        break label90;
      }
      i = 3;
      if (!paramString.isSameType("voicesticker")) {
        break label63;
      }
      paramString = "VSTART_" + paramString.getId();
    }
    for (;;)
    {
      b(i, paramString);
      return;
      label63:
      paramString = "START_" + paramString.getId();
      continue;
      label90:
      i = 1;
      paramString = paramString.getId();
    }
  }
  
  private void e(String paramString)
  {
    int j = 3;
    String str;
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      str = "START_0";
      i = 3;
      paramString = (FaceItem)a(paramString);
      if (paramString == null) {
        break label93;
      }
      if (!paramString.isInteract()) {
        break label82;
      }
      str = "STOP" + paramString.getId();
      i = j;
    }
    label82:
    label93:
    for (;;)
    {
      b(i, str);
      return;
      str = "0";
      i = 1;
      break;
      str = paramString.getId();
      i = 1;
    }
  }
  
  public int a()
  {
    return 176;
  }
  
  public int a(int paramInt, String paramString)
  {
    long l = AudioHelper.b();
    QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onReceivedMessageOfPeer, type[" + paramInt + "], seq[" + l + "], info[" + paramString + "]");
    String str1;
    if (paramInt == 3)
    {
      paramInt = paramString.indexOf('_');
      if (paramInt == -1) {
        return -1;
      }
      str1 = paramString.substring(0, paramInt);
      String str2 = paramString.substring(paramInt + 1, paramString.length());
      boolean bool1 = "START".equals(str1);
      boolean bool2 = "VSTART".equals(str1);
      if ((bool1) || (bool2)) {
        if ((!"0".equalsIgnoreCase(str2)) && (!"0_iOS".equalsIgnoreCase(str2)))
        {
          if (bool1) {
            a(l, 6104, paramString, null);
          }
          new lrz(l, str2, false, 4).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
          a(l, 164, Integer.valueOf(0), null);
        }
      }
    }
    for (;;)
    {
      return 0;
      a(l, 6101, null, Boolean.valueOf(false));
      continue;
      if ("STOP".equals(str1))
      {
        continue;
        if (paramInt == 1) {
          new lrz(l, paramString, false, 4).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        }
      }
    }
  }
  
  public FaceItem a()
  {
    if ((this.jdField_a_of_type_Kxb != null) && (((FaceItem)this.jdField_a_of_type_Kxb).isSameType("creativecop"))) {
      return (FaceItem)this.jdField_a_of_type_Kxb;
    }
    return null;
  }
  
  public FaceItem a(String paramString)
  {
    List localList = a("voicesticker");
    if (localList != null)
    {
      int i = 0;
      while (i < localList.size())
      {
        if (((FaceItem)localList.get(i)).voice_text != null)
        {
          int j = 0;
          while (j < ((FaceItem)localList.get(i)).voice_text.length)
          {
            if (TextUtils.equals(paramString, ((FaceItem)localList.get(i)).voice_text[j])) {
              return (FaceItem)localList.get(i);
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
    return null;
  }
  
  public Class<?> a()
  {
    return FaceItem.class;
  }
  
  public ArrayList<kxj> a()
  {
    return this.jdField_b_of_type_JavaUtilArrayList;
  }
  
  public List<FaceItem> a(int paramInt, String paramString)
  {
    int j = 0;
    int i = 0;
    try
    {
      Object localObject1 = new JSONObject(paramString);
      Object localObject2;
      if (paramInt == 176)
      {
        if ((QLog.isColorLevel()) && (((JSONObject)localObject1).has("version"))) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "parseConfig： version=" + ((JSONObject)localObject1).getString("version"));
        }
        if (((JSONObject)localObject1).has("black_list"))
        {
          localObject1 = ((JSONObject)localObject1).getJSONArray("black_list");
          while (i < ((JSONArray)localObject1).length())
          {
            localObject2 = ((JSONArray)localObject1).getString(i);
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject2);
            i += 1;
          }
        }
      }
      else if (paramInt == 370)
      {
        if (((JSONObject)localObject1).has("blessingTips"))
        {
          localObject2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
          ((SimpleDateFormat)localObject2).setTimeZone(TimeZone.getTimeZone("GMT+8"));
          JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("blessingTips");
          i = j;
          while (i < localJSONArray.length())
          {
            JSONObject localJSONObject = localJSONArray.getJSONObject(i);
            kxj localkxj = new kxj();
            localkxj.jdField_a_of_type_JavaLangString = localJSONObject.optString("id");
            if (localJSONObject.has("start_date")) {
              localkxj.jdField_a_of_type_Long = ((SimpleDateFormat)localObject2).parse(localJSONObject.optString("start_date")).getTime();
            }
            if (localJSONObject.has("end_date")) {
              localkxj.jdField_b_of_type_Long = ((SimpleDateFormat)localObject2).parse(localJSONObject.optString("end_date")).getTime();
            }
            if (localJSONObject.has("text")) {
              localkxj.jdField_b_of_type_JavaLangString = localJSONObject.getString("text");
            }
            if (localJSONObject.has("image_url")) {
              localkxj.c = localJSONObject.getString("image_url");
            }
            if (localJSONObject.has("call_time_len")) {
              localkxj.jdField_a_of_type_Int = localJSONObject.getInt("call_time_len");
            }
            if (localJSONObject.has("show_time_len")) {
              localkxj.jdField_b_of_type_Int = localJSONObject.getInt("show_time_len");
            }
            this.jdField_b_of_type_JavaUtilArrayList.add(localkxj);
            QLog.w(this.jdField_a_of_type_JavaLangString, 1, "parseConfig, blessingTips[" + localkxj + "]");
            i += 1;
          }
        }
        localObject1 = ((JSONObject)localObject1).optJSONObject("triggerTips");
        if (localObject1 != null)
        {
          this.jdField_a_of_type_Kxk.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("exposure_show_time_len", 5);
          this.jdField_a_of_type_Kxk.jdField_b_of_type_Int = ((JSONObject)localObject1).optInt("exposure_call_time", 2);
          this.jdField_a_of_type_Kxk.c = ((JSONObject)localObject1).optInt("click_call_time", 2);
          this.jdField_a_of_type_Kxk.d = ((JSONObject)localObject1).optInt("click_show_time_len", 5);
          this.jdField_a_of_type_Kxk.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("exposure_show_text", this.jdField_a_of_type_Kxk.jdField_a_of_type_JavaLangString);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    return super.a(paramInt, paramString);
  }
  
  public List<FaceItem> a(String paramString)
  {
    List localList = super.a(paramString);
    ArrayList localArrayList = new ArrayList();
    if (localList != null)
    {
      if (!TextUtils.isEmpty(paramString))
      {
        int j = localList.size();
        int i = 0;
        while (i < j)
        {
          FaceItem localFaceItem = (FaceItem)localList.get(i);
          if (localFaceItem.isSameType(paramString)) {
            localArrayList.add(localFaceItem);
          }
          i += 1;
        }
      }
      localArrayList.addAll(localList);
    }
    return localArrayList;
  }
  
  public kxk a()
  {
    return this.jdField_a_of_type_Kxk;
  }
  
  public void a()
  {
    super.a();
    kxd localkxd = (kxd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
    if (localkxd != null) {
      localkxd.a(3003, this);
    }
    this.jdField_a_of_type_Kyo = ((kyo)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5));
  }
  
  protected void a(long paramLong, int paramInt, Object paramObject1, Object paramObject2)
  {
    if (QLog.isColorLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "notifyEvent, event[" + paramInt + "], value[" + paramObject1 + "], value2[" + paramObject2 + "], seq[" + paramLong + "]");
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(paramInt), paramObject1, paramObject2 });
  }
  
  protected void a(long paramLong, int paramInt, String paramString1, String paramString2)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      a(paramLong, 6101, null, Boolean.valueOf(false));
      new lsa(paramLong, "onSessionStatusChanged", 5, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      kxl.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString1);
      kxl.a(2, paramString1);
      kxl.a(2);
      return;
    }
    a(paramLong, 6101, null, Boolean.valueOf(false));
  }
  
  public void a(long paramLong, String paramString)
  {
    a(paramLong, 165, Integer.valueOf(2), null);
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    Object localObject = (MagicFaceDataEntity)this.jdField_a_of_type_JavaUtilQueue.peek();
    boolean bool2;
    if ((this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.b().equalsIgnoreCase(paramString)) && (localObject != null))
    {
      bool2 = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.a((kxt)localObject);
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilQueue.size() < 8) {
          a(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity);
        }
      }
    }
    for (boolean bool1 = bool2;; bool1 = false)
    {
      if (AudioHelper.e()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onEndMagicPlay, id[" + paramString + "], reason[" + paramInt + "], cur[" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity + "], next[" + localObject + "], size[" + this.jdField_a_of_type_JavaUtilQueue.size() + "], needBeRestore[" + bool1 + "], mLastPendantId[" + this.f + "], seq[" + paramLong + "]");
      }
      a("onEndMagicPlay.1");
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity = null;
      localObject = (FaceItem)a(paramString);
      if ((localObject != null) && ((((FaceItem)localObject).isSameType("voicesticker")) || (((FaceItem)localObject).isSameType("face")))) {
        lja.a().b(2);
      }
      bool1 = a(paramLong);
      a("onEndMagicPlay.2_" + bool1);
      if (!bool1)
      {
        a(paramLong, 6101, paramString, Boolean.valueOf(false));
        if (!TextUtils.isEmpty(this.f))
        {
          ((kyd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).a(paramLong, this.f);
          a(paramLong, 6102, null, null);
          this.f = null;
        }
      }
      a(paramLong, 165, Integer.valueOf(3), null);
      return;
    }
  }
  
  public void a(long paramLong, String paramString, boolean paramBoolean) {}
  
  public void a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(168), paramMessage.obj });
  }
  
  void a(MagicFaceDataEntity paramMagicFaceDataEntity)
  {
    if (paramMagicFaceDataEntity == null) {
      return;
    }
    Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
    MagicFaceDataEntity localMagicFaceDataEntity;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localMagicFaceDataEntity = (MagicFaceDataEntity)localIterator.next();
    } while (!localMagicFaceDataEntity.c());
    for (;;)
    {
      this.jdField_a_of_type_JavaUtilQueue.offer(paramMagicFaceDataEntity);
      if (localMagicFaceDataEntity != null)
      {
        this.jdField_a_of_type_JavaUtilQueue.remove(localMagicFaceDataEntity);
        if (!paramMagicFaceDataEntity.c()) {
          this.jdField_a_of_type_JavaUtilQueue.offer(localMagicFaceDataEntity);
        }
      }
      a("addItemToQueue");
      return;
      localMagicFaceDataEntity = null;
    }
  }
  
  void a(String paramString)
  {
    if (QLog.isDevelopLevel())
    {
      paramString = paramString + "\n";
      paramString = paramString + "size :" + this.jdField_a_of_type_JavaUtilQueue.size() + "\n";
      Iterator localIterator = this.jdField_a_of_type_JavaUtilQueue.iterator();
      int i = 0;
      while (localIterator.hasNext())
      {
        MagicFaceDataEntity localMagicFaceDataEntity = (MagicFaceDataEntity)localIterator.next();
        paramString = paramString + i + ":" + localMagicFaceDataEntity + "\n";
        i += 1;
      }
      paramString = paramString + "\ncur :" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity;
      paramString = paramString + "\nmLastPendantId :" + this.f;
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "printQueue, " + paramString);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    FaceItem localFaceItem = a();
    if (localFaceItem == null) {
      return;
    }
    long l = AudioHelper.b();
    if (AudioHelper.e()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "stop, id[" + paramString2 + "], reason[" + paramString1 + "], seq[" + l + "]");
    }
    a(l, 6101, localFaceItem.getId(), Boolean.valueOf(true));
    kxl.a(4, paramString2);
    kxl.a(4);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    if ((paramBoolean) && (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d))) {
      this.f = null;
    }
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.a())) || ((this.g != null) && (this.jdField_a_of_type_Boolean));
  }
  
  public boolean a(int paramInt, String paramString, boolean paramBoolean)
  {
    long l = AudioHelper.b();
    if (AudioHelper.e()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "stop, id[" + paramString + "], reason[" + paramInt + "], isSender[" + paramBoolean + "], seq[" + l + "]");
    }
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity != null)
    {
      String str = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.b();
      if ((TextUtils.isEmpty(paramString)) || (str.equalsIgnoreCase(paramString)))
      {
        this.jdField_a_of_type_JavaUtilQueue.clear();
        krx.e(this.jdField_a_of_type_JavaLangString, "stop dequeue" + paramString);
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity = null;
        if (paramBoolean) {
          e(paramString);
        }
        a(l, null);
        if (this.jdField_a_of_type_Kxv.a())
        {
          this.jdField_a_of_type_Kxv.b();
          krx.e(this.jdField_a_of_type_JavaLangString, "stop " + paramString + ", mStopType =" + paramInt);
        }
      }
    }
    if ((this.g != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity == null) && ((TextUtils.isEmpty(paramString)) || (this.g.equalsIgnoreCase(paramString))))
    {
      if (paramBoolean) {
        c(null);
      }
      a(l, null);
      this.g = null;
    }
    return true;
  }
  
  public boolean a(long paramLong, FaceItem paramFaceItem)
  {
    boolean bool2 = super.a(paramLong, paramFaceItem);
    String str;
    int j;
    boolean bool1;
    int i;
    if ((paramFaceItem != null) && (paramFaceItem.isSameType("creativecop")))
    {
      str = c(paramFaceItem);
      ((FaceItem)this.jdField_a_of_type_Kxb).setDesc(str);
      awqx.b(null, "CliOper", "", "", "0X800A74C", "0X800A74C", 0, 0, "", "", paramFaceItem.getId(), "");
      j = b();
      if (this.jdField_a_of_type_Kyo.a(3, "creative") != 1) {
        break label274;
      }
      bool1 = true;
      i = 0;
      if (j == 0) {
        break label288;
      }
      if (j != 2) {
        break label280;
      }
      i = 2131630060;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setCurrentItem , TYPE_STR_INTERACTIVE_VIDEO seq[" + paramLong + "]" + str + "[peerPowerSupport:=" + bool1 + "],[peerVersionSupport:=" + j);
      }
      if (i != 0) {
        lqb.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1010, i);
      }
      if (bool2)
      {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101, this.jdField_a_of_type_Kxb).sendToTarget();
        if (paramFaceItem != null)
        {
          paramFaceItem = paramFaceItem.getType();
          if ((!paramFaceItem.equalsIgnoreCase("face")) && (!paramFaceItem.equalsIgnoreCase("voicesticker"))) {
            this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(new Object[] { Integer.valueOf(3003) });
          }
        }
      }
      return bool2;
      label274:
      bool1 = false;
      break;
      label280:
      i = 2131630059;
      continue;
      label288:
      if (!bool1) {
        i = 2131630059;
      }
    }
  }
  
  public boolean a(long paramLong, FaceItem paramFaceItem, String paramString, boolean paramBoolean, kxs paramkxs)
  {
    boolean bool2 = true;
    if (AudioHelper.e()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "start, id[" + paramString + "], curData[" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity + "], isSender[" + paramBoolean + "], queue[" + this.jdField_a_of_type_JavaUtilQueue.size() + "], isPlaying[" + this.jdField_a_of_type_Kxv.a() + "], mLastPendantId[" + this.f + "], seq[" + paramLong + "]");
    }
    boolean bool1;
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilQueue.size() >= 8) || ((this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity != null) && (paramString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.b()))) || ((this.g != null) && (this.g.equalsIgnoreCase(paramString))))
    {
      bool1 = false;
      return bool1;
    }
    boolean bool3 = paramFaceItem.isSameType("creativecop");
    if (bool3)
    {
      this.g = paramString;
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Kxs = paramkxs;
      if ((this.jdField_a_of_type_Kxv == null) || (!this.jdField_a_of_type_Kxv.a())) {
        break label460;
      }
      if (bool3) {
        break label546;
      }
      paramFaceItem = a(paramString, paramBoolean);
      a(paramFaceItem);
    }
    for (;;)
    {
      this.jdField_a_of_type_Kxv.b();
      for (;;)
      {
        label268:
        Object localObject;
        int i;
        if ((paramFaceItem != null) || (bool3))
        {
          paramkxs = this.f;
          a(paramLong, paramString);
          if ((paramFaceItem == null) || (!paramFaceItem.b())) {
            break label504;
          }
          paramFaceItem = (kyd)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
          localObject = (PendantItem)paramFaceItem.a();
          if ((localObject == null) || (!((PendantItem)localObject).isShow()) || (TextUtils.isEmpty(((PendantItem)localObject).getId()))) {
            break label498;
          }
          this.f = ((PendantItem)localObject).getId();
          localObject = (FaceItem)a();
          paramFaceItem.a(paramLong, null);
          i = 1;
        }
        for (;;)
        {
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "start, step[" + i + "], mLastPendantId[" + paramkxs + "->" + this.f + "]");
          if ((!paramBoolean) || (bool3)) {
            break label515;
          }
          d(paramString);
          return true;
          this.g = null;
          break;
          label460:
          if (bool3) {
            break label541;
          }
          localObject = a(paramString, paramBoolean);
          paramFaceItem = (FaceItem)localObject;
          if (localObject == null) {
            break label268;
          }
          a(paramLong, (MagicFaceDataEntity)localObject, paramkxs);
          paramFaceItem = (FaceItem)localObject;
          break label268;
          label498:
          i = 2;
          continue;
          label504:
          i = 3;
          this.f = null;
        }
        label515:
        bool1 = bool2;
        if (!paramBoolean) {
          break;
        }
        bool1 = bool2;
        if (!bool3) {
          break;
        }
        b(paramString);
        return true;
        label541:
        paramFaceItem = null;
      }
      label546:
      paramFaceItem = null;
    }
  }
  
  protected boolean a(String paramString)
  {
    if (ley.b()) {
      ley.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    return true;
  }
  
  public String b()
  {
    return "resources";
  }
  
  public void b()
  {
    long l = AudioHelper.b();
    if (QLog.isDevelopLevel()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "MuteByOthers, seq[" + l + "]");
    }
    if (this.jdField_a_of_type_JavaUtilQueue != null) {
      this.jdField_a_of_type_JavaUtilQueue.clear();
    }
    this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity = null;
    this.g = null;
    a(l, null);
    if (this.jdField_a_of_type_Kxv.a()) {
      this.jdField_a_of_type_Kxv.b();
    }
  }
  
  public void b(long paramLong, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     kxi
 * JD-Core Version:    0.7.0.1
 */