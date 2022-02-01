import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.avgame.ipc.MapParcelable;
import com.tencent.avgame.ipc.UserInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCServer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;

public class nmy
  extends QIPCModule
{
  private static int jdField_a_of_type_Int = 0;
  private static nmy jdField_a_of_type_Nmy;
  private static boolean jdField_a_of_type_Boolean;
  private anvi jdField_a_of_type_Anvi;
  private final ConcurrentHashMap<String, nnd> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(8);
  private nhq jdField_a_of_type_Nhq;
  private nnc jdField_a_of_type_Nnc;
  
  private nmy(String paramString)
  {
    super(paramString);
    if (jdField_a_of_type_Int != 1) {
      jdField_a_of_type_Int = 1;
    }
  }
  
  private UserInfo a(int paramInt, String paramString, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return null;
    }
    UserInfo localUserInfo = new UserInfo(paramString);
    Object localObject = (anvk)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (localObject != null)
    {
      localObject = ((anvk)localObject).e(paramString);
      if (localObject != null)
      {
        localUserInfo.jdField_b_of_type_JavaLangString = ((Friends)localObject).getFriendNickWithAlias();
        localUserInfo.jdField_b_of_type_Int = ((Friends)localObject).age;
        localUserInfo.jdField_c_of_type_Int = ((Friends)localObject).gender;
        localUserInfo.jdField_a_of_type_Boolean = ((Friends)localObject).isFriend();
      }
      localUserInfo.jdField_c_of_type_JavaLangString = paramQQAppInterface.getCustomFaceFilePath(1, paramString, 200);
    }
    if ((TextUtils.equals(paramString, localUserInfo.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(localUserInfo.jdField_b_of_type_JavaLangString)))
    {
      paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.getFriendInfo(paramString);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVGameServerIPCModule", 2, "getUserInfo, type[" + paramInt + "], uin[" + paramString + "], info[" + localUserInfo + "]");
    }
    return localUserInfo;
  }
  
  private EIPCResult a(Bundle paramBundle, @NotNull QQAppInterface paramQQAppInterface)
  {
    int i = paramBundle.getInt("key_type", 0);
    paramBundle = paramBundle.getString("key_uin");
    a(paramBundle, 1, paramQQAppInterface);
    Bundle localBundle = new Bundle();
    paramQQAppInterface = a(i, paramBundle, paramQQAppInterface);
    localBundle.putString("key_uin", paramBundle);
    localBundle.putInt("key_type", i);
    localBundle.putParcelable("key_result", paramQQAppInterface);
    return EIPCResult.createSuccessResult(localBundle);
  }
  
  private EIPCResult a(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Nnc == null) {
      this.jdField_a_of_type_Nnc = new nnc(this);
    }
    boolean bool = bdee.a(paramQQAppInterface, paramQQAppInterface.getApplication().getApplicationContext(), this.jdField_a_of_type_Nnc);
    if (QLog.isColorLevel()) {
      QLog.w("AVGameServerIPCModule", 2, "checkPtvSoIsLoadOk, ret[" + bool + "]");
    }
    if (bool) {}
    for (int i = 0;; i = -102) {
      return EIPCResult.createResult(i, null);
    }
  }
  
  public static nmy a()
  {
    if (jdField_a_of_type_Nmy == null) {}
    try
    {
      if (jdField_a_of_type_Nmy == null) {
        jdField_a_of_type_Nmy = new nmy("AVGameServerIPCModule");
      }
      return jdField_a_of_type_Nmy;
    }
    finally {}
  }
  
  private static void a()
  {
    if (jdField_a_of_type_Boolean) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVGameServerIPCModule", 2, "init");
    }
    jdField_a_of_type_Boolean = true;
    QIPCServerHelper.getInstance().getServer().addListener(new nna());
  }
  
  private void a(Bundle paramBundle, QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramBundle = (ncz)paramQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
      if (paramBundle != null) {
        paramBundle.a(9);
      }
    }
  }
  
  private void a(Bundle paramBundle, @NotNull QQAppInterface paramQQAppInterface, int paramInt)
  {
    String str = paramBundle.getString("key_room_id");
    int i = paramBundle.getInt("status");
    paramBundle = (ncz)paramQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if (paramBundle == null)
    {
      QLog.e("AVGameServerIPCModule", 2, "setCurrentAvGameStatus AV_GAME_MANAGER NULL");
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
      return;
    }
    paramBundle.a(i, str);
    callbackResult(paramInt, EIPCResult.createSuccessResult(null));
  }
  
  private void a(String paramString, int paramInt, QQAppInterface paramQQAppInterface)
  {
    nnd localnnd2 = (nnd)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    nnd localnnd1 = localnnd2;
    if (localnnd2 == null)
    {
      localnnd1 = new nnd();
      localnnd1.jdField_a_of_type_JavaLangString = paramString;
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localnnd1);
    }
    if ((paramInt >= 0) && (paramInt < localnnd1.jdField_a_of_type_ArrayOfBoolean.length)) {
      localnnd1.jdField_a_of_type_ArrayOfBoolean[paramInt] = true;
    }
    if ((paramQQAppInterface != null) && (this.jdField_a_of_type_Anvi == null) && ((paramInt == 1) || (paramInt == 0)))
    {
      this.jdField_a_of_type_Anvi = new nnb(this, paramQQAppInterface);
      paramQQAppInterface.addObserver(this.jdField_a_of_type_Anvi, true);
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Int == 0) {
      a();
    }
    return jdField_a_of_type_Int == 1;
  }
  
  private boolean a(String paramString, int paramInt)
  {
    paramString = (nnd)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if ((paramString != null) && (paramInt >= 0) && (paramInt < paramString.jdField_a_of_type_ArrayOfBoolean.length)) {
      return paramString.jdField_a_of_type_ArrayOfBoolean[paramInt];
    }
    return false;
  }
  
  private EIPCResult b(Bundle paramBundle, @NotNull QQAppInterface paramQQAppInterface)
  {
    int i = paramBundle.getInt("key_face_type");
    String str = paramBundle.getString("key_uin");
    byte b = paramBundle.getByte("key_shape");
    int j = paramBundle.getInt("key_id_type");
    a(str, 0, paramQQAppInterface);
    paramBundle = null;
    if (!TextUtils.isEmpty(str)) {
      paramBundle = paramQQAppInterface.getFaceBitmap(i, str, b, true, j);
    }
    if (QLog.isColorLevel()) {
      QLog.i("AVGameServerIPCModule", 2, "getUserHead, type[" + i + "], uin[" + str + "], shape[" + b + "], idType[" + j + "]");
    }
    paramQQAppInterface = new Bundle();
    paramQQAppInterface.putParcelable("key_result", paramBundle);
    return EIPCResult.createSuccessResult(paramQQAppInterface);
  }
  
  private void b(Bundle paramBundle, QQAppInterface paramQQAppInterface, int paramInt)
  {
    int i = paramBundle.getInt("key_type");
    String str = paramBundle.getString("key_uin");
    paramBundle = paramBundle.getString("key_room_id");
    paramQQAppInterface = (ncz)paramQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER);
    if (paramQQAppInterface == null)
    {
      QLog.e("AVGameServerIPCModule", 2, "notifySendMsg AV_GAME_MANAGER NULL");
      callbackResult(paramInt, EIPCResult.createResult(-102, null));
      return;
    }
    paramQQAppInterface.a(i, str, paramBundle);
    callbackResult(paramInt, EIPCResult.createSuccessResult(null));
  }
  
  private EIPCResult c(Bundle paramBundle, @NotNull QQAppInterface paramQQAppInterface)
  {
    int i = paramBundle.getInt("key_type");
    paramBundle = paramBundle.getStringArrayList("key_uin_list");
    if (paramBundle == null) {
      paramBundle = new ArrayList();
    }
    for (;;)
    {
      MapParcelable localMapParcelable = new MapParcelable();
      Iterator localIterator = paramBundle.iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        String str2 = ContactUtils.getFriendDisplayName(paramQQAppInterface, str1);
        if ((!TextUtils.isEmpty(str2)) && (!str2.equalsIgnoreCase(str1))) {
          localMapParcelable.a.put(str1, str2);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.i("AVGameServerIPCModule", 2, String.format(Locale.getDefault(), "getNicks %d size=%d foundSize=%d", new Object[] { Integer.valueOf(i), Integer.valueOf(paramBundle.size()), Integer.valueOf(localMapParcelable.a.size()) }));
      }
      paramBundle = new Bundle();
      paramBundle.putInt("key_type", i);
      paramBundle.putParcelable("key_result", localMapParcelable);
      return EIPCResult.createSuccessResult(paramBundle);
    }
  }
  
  private void c(Bundle paramBundle, QQAppInterface paramQQAppInterface, int paramInt)
  {
    String str1 = paramBundle.getString("key_play_game_id");
    String str2 = paramBundle.getString("key_pic_path");
    paramBundle = paramBundle.getString("key_video_path");
    if (this.jdField_a_of_type_Nhq == null) {
      this.jdField_a_of_type_Nhq = new nmz(this);
    }
    ((ncz)paramQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER)).a().a(paramQQAppInterface, str1, str2, paramBundle, this.jdField_a_of_type_Nhq);
  }
  
  private void d(Bundle paramBundle, QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramBundle = paramBundle.getString("key_play_game_id");
    ((ncz)paramQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER)).a().a(paramBundle);
  }
  
  private void e(Bundle paramBundle, QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramBundle = paramBundle.getString("key_play_game_id");
    ((ncz)paramQQAppInterface.getManager(QQManagerFactory.AV_GAME_MANAGER)).a().b(paramBundle);
  }
  
  protected void a(int paramInt1, String paramString, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_face_type", paramInt1);
    localBundle.putString("key_uin", paramString);
    localBundle.putInt("key_id_type", paramInt2);
    QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:avgame", 1, "AVGameClientQIPCModule", "action_notify_user_head_change", localBundle);
  }
  
  protected void a(int paramInt, String paramString, UserInfo paramUserInfo)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_type", paramInt);
    localBundle.putString("key_uin", paramString);
    localBundle.putParcelable("key_result", paramUserInfo);
    QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:avgame", 1, "AVGameClientQIPCModule", "action_notify_user_info_change", localBundle);
  }
  
  protected void a(int paramInt, boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_event_id", paramInt);
    localBundle.putBoolean("key_event_ret", paramBoolean);
    localBundle.putString("key_event_msg", paramString);
    QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:avgame", 1, "AVGameClientQIPCModule", "action_notify_event", localBundle);
  }
  
  protected void a(boolean paramBoolean, String paramString1, int paramInt, String paramString2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_event_ret", paramBoolean);
    localBundle.putString("key_play_game_id", paramString1);
    localBundle.putInt("key_file_type", paramInt);
    localBundle.putString("key_file_url", paramString2);
    QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:avgame", 1, "AVGameClientQIPCModule", "action_notify_game_result_upload", localBundle);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameServerIPCModule", 2, "onCall, action[" + paramString + "], state[" + jdField_a_of_type_Int + "]");
    }
    if (jdField_a_of_type_Int != 1) {
      jdField_a_of_type_Int = 1;
    }
    Object localObject = BaseApplicationImpl.sApplication.getRuntime();
    if (!(localObject instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.e("AVGameServerIPCModule", 2, "[onCall] get app failed.");
      }
      return null;
    }
    localObject = (QQAppInterface)localObject;
    if ("action_get_user_info".equals(paramString)) {
      paramString = a(paramBundle, (QQAppInterface)localObject);
    }
    for (;;)
    {
      return paramString;
      if ("action_get_user_head".equals(paramString))
      {
        paramString = b(paramBundle, (QQAppInterface)localObject);
      }
      else if ("action_get_nicks".equals(paramString))
      {
        paramString = c(paramBundle, (QQAppInterface)localObject);
      }
      else if ("action_check_ptv_so_load_ok".equals(paramString))
      {
        paramString = a((QQAppInterface)localObject);
      }
      else if ("action_set_cur_av_game_status".equals(paramString))
      {
        a(paramBundle, (QQAppInterface)localObject, paramInt);
        paramString = null;
      }
      else if ("action_notify_send_msg".equals(paramString))
      {
        b(paramBundle, (QQAppInterface)localObject, paramInt);
        paramString = null;
      }
      else if ("action_upload_game_result_resources".equals(paramString))
      {
        c(paramBundle, (QQAppInterface)localObject, paramInt);
        paramString = null;
      }
      else if ("action_clean_game_result_resources".equals(paramString))
      {
        e(paramBundle, (QQAppInterface)localObject, paramInt);
        paramString = null;
      }
      else if ("action_upload_game_result_video".equals(paramString))
      {
        d(paramBundle, (QQAppInterface)localObject, paramInt);
        paramString = null;
      }
      else
      {
        if ("action_notify_game_start_match".equals(paramString)) {
          a(paramBundle, (QQAppInterface)localObject);
        }
        paramString = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nmy
 * JD-Core Version:    0.7.0.1
 */