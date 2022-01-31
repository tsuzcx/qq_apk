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

public class lhw
  extends EffectConfigBase<FaceItem>
  implements lht, lif
{
  public static final String d = lco.a() + 176 + File.separator;
  private MagicFaceDataEntity jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private Queue<MagicFaceDataEntity> jdField_a_of_type_JavaUtilQueue = new ArrayBlockingQueue(8);
  lhy jdField_a_of_type_Lhy = new lhy();
  private lig jdField_a_of_type_Lig;
  private lij jdField_a_of_type_Lij = new lij();
  private lje jdField_a_of_type_Lje;
  private boolean jdField_a_of_type_Boolean;
  private ArrayList<lhx> b = new ArrayList();
  private String e;
  private String f;
  
  public lhw(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private MagicFaceDataEntity a(FaceItem paramFaceItem, String paramString, boolean paramBoolean, int paramInt)
  {
    String str1 = null;
    String str2;
    if (paramFaceItem != null)
    {
      lcl.c(this.jdField_a_of_type_JavaLangString, String.format("createMagicEntity: id=%s, senderType%s.", new Object[] { paramFaceItem.getId(), Integer.valueOf(paramInt) }));
      str1 = paramFaceItem.getId();
      str2 = paramFaceItem.getType();
      if (!"multi_result".equalsIgnoreCase(paramFaceItem.getAttr())) {
        break label100;
      }
      paramString = new lid(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str1, str2, paramString, paramBoolean, paramInt);
    }
    for (;;)
    {
      paramFaceItem.lastPositionIndex = paramString.a(paramFaceItem.lastPositionIndex);
      str1 = paramString;
      return str1;
      label100:
      if ("huanlian".equalsIgnoreCase(paramFaceItem.getAttr())) {
        paramString = new mad(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, str1, str2, paramString, paramBoolean, paramInt);
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
        localObject = bbdj.a((File)localObject);
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
      this.jdField_a_of_type_Lhm.a(paramString, a(paramString), b(paramString), localArrayList, false);
      lcl.e(this.jdField_a_of_type_JavaLangString, "prepareEntity FILE not exist: " + ((File)localObject).getPath());
    }
    return null;
  }
  
  private void a(long paramLong, MagicFaceDataEntity paramMagicFaceDataEntity, lig paramlig)
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
            ltr.a().a(2);
          }
          this.jdField_a_of_type_Lij.a(paramLong, str, paramMagicFaceDataEntity, paramlig, this);
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
      a(paramLong, localMagicFaceDataEntity, this.jdField_a_of_type_Lig);
      a(paramLong, localMagicFaceDataEntity.b());
      if (localMagicFaceDataEntity.c())
      {
        a(paramLong, 6102, null, null);
        this.e = null;
      }
      return true;
    }
    return false;
  }
  
  private int b()
  {
    int j = 0;
    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    lgf locallgf = localVideoController.a();
    int i = localVideoController.b(locallgf.d);
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
      k = localVideoController.c(locallgf.d);
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
          new mcp(l, str2, false, 4).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
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
          new mcp(l, paramString, false, 4).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
        }
      }
    }
  }
  
  public FaceItem a()
  {
    if ((this.jdField_a_of_type_Lhq != null) && (((FaceItem)this.jdField_a_of_type_Lhq).isSameType("creativecop"))) {
      return (FaceItem)this.jdField_a_of_type_Lhq;
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
  
  public ArrayList<lhx> a()
  {
    return this.b;
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
            lhx locallhx = new lhx();
            locallhx.jdField_a_of_type_JavaLangString = localJSONObject.optString("id");
            if (localJSONObject.has("start_date")) {
              locallhx.jdField_a_of_type_Long = ((SimpleDateFormat)localObject2).parse(localJSONObject.optString("start_date")).getTime();
            }
            if (localJSONObject.has("end_date")) {
              locallhx.jdField_b_of_type_Long = ((SimpleDateFormat)localObject2).parse(localJSONObject.optString("end_date")).getTime();
            }
            if (localJSONObject.has("text")) {
              locallhx.jdField_b_of_type_JavaLangString = localJSONObject.getString("text");
            }
            if (localJSONObject.has("image_url")) {
              locallhx.c = localJSONObject.getString("image_url");
            }
            if (localJSONObject.has("call_time_len")) {
              locallhx.jdField_a_of_type_Int = localJSONObject.getInt("call_time_len");
            }
            if (localJSONObject.has("show_time_len")) {
              locallhx.jdField_b_of_type_Int = localJSONObject.getInt("show_time_len");
            }
            this.b.add(locallhx);
            QLog.w(this.jdField_a_of_type_JavaLangString, 1, "parseConfig, blessingTips[" + locallhx + "]");
            i += 1;
          }
        }
        localObject1 = ((JSONObject)localObject1).optJSONObject("triggerTips");
        if (localObject1 != null)
        {
          this.jdField_a_of_type_Lhy.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("exposure_show_time_len", 5);
          this.jdField_a_of_type_Lhy.jdField_b_of_type_Int = ((JSONObject)localObject1).optInt("exposure_call_time", 2);
          this.jdField_a_of_type_Lhy.c = ((JSONObject)localObject1).optInt("click_call_time", 2);
          this.jdField_a_of_type_Lhy.d = ((JSONObject)localObject1).optInt("click_show_time_len", 5);
          this.jdField_a_of_type_Lhy.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("exposure_show_text", this.jdField_a_of_type_Lhy.jdField_a_of_type_JavaLangString);
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
  
  public lhy a()
  {
    return this.jdField_a_of_type_Lhy;
  }
  
  public void a()
  {
    super.a();
    lhs locallhs = (lhs)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
    if (locallhs != null) {
      locallhs.a(3003, this);
    }
    this.jdField_a_of_type_Lje = ((lje)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(5));
  }
  
  public void a(int paramInt, String paramString)
  {
    boolean bool2 = false;
    long l = AudioHelper.b();
    boolean bool1;
    if (paramInt == 3003) {
      bool1 = bool2;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 2, "MuteByOthers, seq[" + l + "], fromMuteKey[" + paramInt + "], data[" + paramString + "], mute[" + bool1 + "]");
      }
      if (bool1)
      {
        if (this.jdField_a_of_type_JavaUtilQueue != null) {
          this.jdField_a_of_type_JavaUtilQueue.clear();
        }
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity = null;
        this.f = null;
        a(l, null);
        if (this.jdField_a_of_type_Lij.a()) {
          this.jdField_a_of_type_Lij.b();
        }
      }
      return;
      bool1 = bool2;
      if (paramInt != 3002) {
        if (paramInt == 3001)
        {
          bool1 = true;
        }
        else
        {
          bool1 = bool2;
          if (paramInt == 3004) {
            bool1 = true;
          }
        }
      }
    }
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
      new mcq(paramLong, "onSessionStatusChanged", 5, null).a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
      lhz.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, paramString1);
      lhz.a(2, paramString1);
      lhz.a(2);
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
      bool2 = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.a((lih)localObject);
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
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "onEndMagicPlay, id[" + paramString + "], reason[" + paramInt + "], cur[" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity + "], next[" + localObject + "], size[" + this.jdField_a_of_type_JavaUtilQueue.size() + "], needBeRestore[" + bool1 + "], mLastPendantId[" + this.e + "], seq[" + paramLong + "]");
      }
      a("onEndMagicPlay.1");
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity = null;
      localObject = (FaceItem)a(paramString);
      if ((localObject != null) && ((((FaceItem)localObject).isSameType("voicesticker")) || (((FaceItem)localObject).isSameType("face")))) {
        ltr.a().b(2);
      }
      bool1 = a(paramLong);
      a("onEndMagicPlay.2_" + bool1);
      if (!bool1)
      {
        a(paramLong, 6101, paramString, Boolean.valueOf(false));
        if (!TextUtils.isEmpty(this.e))
        {
          ((liv)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2)).a(paramLong, this.e);
          a(paramLong, 6102, null, null);
          this.e = null;
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
      paramString = paramString + "\nmLastPendantId :" + this.e;
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "printQueue, " + paramString);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    FaceItem localFaceItem = a();
    if (localFaceItem == null) {}
    long l;
    do
    {
      return;
      l = AudioHelper.b();
      if (AudioHelper.e()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "stop, id[" + paramString2 + "], reason[" + paramString1 + "], seq[" + l + "]");
      }
      a(l, 6101, localFaceItem.getId(), Boolean.valueOf(true));
      lhz.a(4, paramString2);
      lhz.a(4);
    } while (!this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(13));
    ((lil)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(13)).a(l, "stopInteractiveVideo");
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    super.a(paramString, paramBoolean);
    if ((paramBoolean) && (paramString.equals(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().d))) {
      this.e = null;
    }
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.a())) || ((this.f != null) && (this.jdField_a_of_type_Boolean));
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
        lcl.e(this.jdField_a_of_type_JavaLangString, "stop dequeue" + paramString);
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity = null;
        if (paramBoolean) {
          e(paramString);
        }
        a(l, null);
        if (this.jdField_a_of_type_Lij.a())
        {
          this.jdField_a_of_type_Lij.b();
          lcl.e(this.jdField_a_of_type_JavaLangString, "stop " + paramString + ", mStopType =" + paramInt);
        }
      }
    }
    if ((this.f != null) && (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity == null) && ((TextUtils.isEmpty(paramString)) || (this.f.equalsIgnoreCase(paramString))))
    {
      if (paramBoolean) {
        c(null);
      }
      a(l, null);
      this.f = null;
    }
    return true;
  }
  
  public boolean a(long paramLong, FaceItem paramFaceItem)
  {
    boolean bool2 = super.a(paramLong, paramFaceItem);
    Object localObject;
    int j;
    boolean bool1;
    int i;
    if ((paramFaceItem != null) && (paramFaceItem.isSameType("creativecop")))
    {
      localObject = c(paramFaceItem);
      ((FaceItem)this.jdField_a_of_type_Lhq).setDesc((String)localObject);
      axqw.b(null, "CliOper", "", "", "0X800A74C", "0X800A74C", 0, 0, "", "", paramFaceItem.getId(), "");
      j = b();
      if (this.jdField_a_of_type_Lje.a(3, "creative") != 1) {
        break label282;
      }
      bool1 = true;
      i = 0;
      if (j == 0) {
        break label296;
      }
      if (j != 2) {
        break label288;
      }
      i = 2131695747;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.jdField_a_of_type_JavaLangString, 1, "setCurrentItem , TYPE_STR_INTERACTIVE_VIDEO seq[" + paramLong + "]" + (String)localObject + "[peerPowerSupport:=" + bool1 + "],[peerVersionSupport:=" + j);
      }
      if (i != 0) {
        mat.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface, 1010, i);
      }
      if (bool2)
      {
        this.jdField_a_of_type_AndroidOsHandler.obtainMessage(101, this.jdField_a_of_type_Lhq).sendToTarget();
        if (paramFaceItem != null)
        {
          paramFaceItem = paramFaceItem.getType();
          if ((!paramFaceItem.equalsIgnoreCase("face")) && (!paramFaceItem.equalsIgnoreCase("voicesticker")))
          {
            localObject = (lhs)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(12);
            if (localObject != null) {
              ((lhs)localObject).a(3003, paramFaceItem);
            }
          }
        }
      }
      return bool2;
      label282:
      bool1 = false;
      break;
      label288:
      i = 2131695746;
      continue;
      label296:
      if (!bool1) {
        i = 2131695746;
      }
    }
  }
  
  public boolean a(long paramLong, FaceItem paramFaceItem, String paramString, boolean paramBoolean, lig paramlig)
  {
    boolean bool2 = true;
    if (AudioHelper.e()) {
      QLog.w(this.jdField_a_of_type_JavaLangString, 1, "start, id[" + paramString + "], curData[" + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity + "], isSender[" + paramBoolean + "], queue[" + this.jdField_a_of_type_JavaUtilQueue.size() + "], isPlaying[" + this.jdField_a_of_type_Lij.a() + "], mLastPendantId[" + this.e + "], seq[" + paramLong + "]");
    }
    boolean bool1;
    if ((TextUtils.isEmpty(paramString)) || (this.jdField_a_of_type_JavaUtilQueue.size() >= 8) || ((this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity != null) && (paramString.equalsIgnoreCase(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicFaceDataEntity.b()))) || ((this.f != null) && (this.f.equalsIgnoreCase(paramString))))
    {
      bool1 = false;
      return bool1;
    }
    boolean bool3 = paramFaceItem.isSameType("creativecop");
    if (bool3)
    {
      this.f = paramString;
      this.jdField_a_of_type_Boolean = paramBoolean;
      this.jdField_a_of_type_Lig = paramlig;
      if ((this.jdField_a_of_type_Lij == null) || (!this.jdField_a_of_type_Lij.a())) {
        break label461;
      }
      if (bool3) {
        break label547;
      }
      paramFaceItem = a(paramString, paramBoolean);
      a(paramFaceItem);
    }
    for (;;)
    {
      this.jdField_a_of_type_Lij.b();
      for (;;)
      {
        label269:
        Object localObject;
        int i;
        if ((paramFaceItem != null) || (bool3))
        {
          paramlig = this.e;
          a(paramLong, paramString);
          if ((paramFaceItem == null) || (!paramFaceItem.b())) {
            break label505;
          }
          paramFaceItem = (liv)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(2);
          localObject = (PendantItem)paramFaceItem.a();
          if ((localObject == null) || (!((PendantItem)localObject).isShow()) || (TextUtils.isEmpty(((PendantItem)localObject).getId()))) {
            break label499;
          }
          this.e = ((PendantItem)localObject).getId();
          localObject = (FaceItem)a();
          paramFaceItem.a(paramLong, null);
          i = 1;
        }
        for (;;)
        {
          QLog.w(this.jdField_a_of_type_JavaLangString, 1, "start, step[" + i + "], mLastPendantId[" + paramlig + "->" + this.e + "]");
          if ((!paramBoolean) || (bool3)) {
            break label516;
          }
          d(paramString);
          return true;
          this.f = null;
          break;
          label461:
          if (bool3) {
            break label542;
          }
          localObject = a(paramString, paramBoolean);
          paramFaceItem = (FaceItem)localObject;
          if (localObject == null) {
            break label269;
          }
          a(paramLong, (MagicFaceDataEntity)localObject, paramlig);
          paramFaceItem = (FaceItem)localObject;
          break label269;
          label499:
          i = 2;
          continue;
          label505:
          i = 3;
          this.e = null;
        }
        label516:
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
        label542:
        paramFaceItem = null;
      }
      label547:
      paramFaceItem = null;
    }
  }
  
  protected boolean a(String paramString)
  {
    if (lpq.b()) {
      lpq.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    return true;
  }
  
  public String b()
  {
    return "resources";
  }
  
  public void b(long paramLong, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     lhw
 * JD-Core Version:    0.7.0.1
 */