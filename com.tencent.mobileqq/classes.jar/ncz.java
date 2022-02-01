import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.media.AudioManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.avgame.business.AvGameManager.2;
import com.tencent.avgame.business.AvGameManager.6;
import com.tencent.avgame.ipc.AVGameUtilService;
import com.tencent.avgame.ui.AvGameLoadingActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.manager.Manager;
import mqq.os.MqqHandler;

public class ncz
  implements Manager
{
  private volatile int jdField_a_of_type_Int;
  private ansi jdField_a_of_type_Ansi;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private ndm jdField_a_of_type_Ndm = new nda(this);
  nho jdField_a_of_type_Nho;
  nnf jdField_a_of_type_Nnf = null;
  
  public ncz(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Nnf = new nnf(paramQQAppInterface);
    this.jdField_a_of_type_Nnf.a();
    paramQQAppInterface.addObserver(this.jdField_a_of_type_Ndm);
  }
  
  private void a(Activity paramActivity, int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManager", 2, "showRealNameDialog roomId: " + paramString2);
    }
    bdla.b(null, "dc00898", "", "", "0X800B077", "0X800B077", paramInt3, 0, "", "", "", "");
    WeakReference localWeakReference = new WeakReference(paramActivity);
    paramActivity = bhdj.a(paramActivity, 230, paramActivity.getString(2131690495), paramActivity.getString(2131690494), paramActivity.getString(2131698775), paramActivity.getString(2131698777), new ndf(this, localWeakReference, paramInt3, paramString2, paramInt1, paramString1, paramInt2, paramActivity), new ndh(this));
    paramActivity.setCancelable(false);
    paramActivity.show();
  }
  
  private void a(Activity paramActivity, boolean paramBoolean)
  {
    String str = paramActivity.getString(2131690313);
    if (!paramBoolean) {
      str = paramActivity.getString(2131690354);
    }
    QQCustomDialog localQQCustomDialog = bhdj.a(paramActivity, 230);
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.setMessage(str);
      QLog.d("AvGameManager", 2, "showInPlayDialog  ");
      paramActivity = new ndd(this, paramActivity);
      localQQCustomDialog.setPositiveButton(2131690470, paramActivity);
      localQQCustomDialog.setNegativeButton(2131690697, paramActivity);
      localQQCustomDialog.show();
      return;
    }
    QLog.e("AvGameManager", 1, "preCheckIsUserGamePlaying dialog null");
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.excute(new AvGameManager.2(paramQQAppInterface), 16, null, true);
  }
  
  private void a(String paramString, boolean paramBoolean)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        return;
        TroopManager localTroopManager = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
        TroopInfo localTroopInfo = localTroopManager.a(paramString);
        if (localTroopInfo == null) {
          break;
        }
        localTroopInfo.setIsAVGameOpen(paramBoolean);
        localTroopManager.b(localTroopInfo);
      } while (!QLog.isColorLevel());
      QLog.d("AvGameManager", 2, "setIsAVGameOpen: " + paramBoolean + " troopUin: " + paramString);
      return;
    } while (!QLog.isColorLevel());
    QLog.e("AvGameManager", 1, "setIsAVGameOpen troopinfo is null! troopUin: " + paramString);
  }
  
  private boolean a(Activity paramActivity, boolean paramBoolean, String paramString)
  {
    if (!a()) {
      return false;
    }
    if (paramBoolean) {
      a(paramActivity, true);
    }
    for (;;)
    {
      return true;
      String str = a();
      if (TextUtils.isEmpty(str))
      {
        QLog.e("AvGameManager", 1, "preCheckIsUserGamePlaying join  roomPlayingId empty");
        return true;
      }
      if (str.equals(paramString))
      {
        c();
        AvGameLoadingActivity.a(false, paramActivity, null, str, null, "", false, false, null);
      }
      else
      {
        a(paramActivity, false);
      }
    }
  }
  
  private boolean a(boolean paramBoolean)
  {
    QLog.d("AvGameManager", 2, "preCheckIsOtherBusinessOpen bCreate " + paramBoolean);
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      QLog.e("AvGameManager", 1, "preCheckIsUserGamePlaying app null");
    }
    do
    {
      return false;
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().a())
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), 2131690283, 1).a();
        QLog.e("AvGameManager", 1, "preCheckIsUserGamePlaying isPhoneCalling");
        return true;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAVNotifyCenter().b())
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), 2131690283, 1).a();
        QLog.e("AvGameManager", 1, "preCheckIsUserGamePlaying isAvChating");
        return true;
      }
    } while (!blvm.a());
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), 2131698595, 1).a();
    QLog.e("AvGameManager", 1, "preCheckIsUserGamePlaying qq is in live show");
    return true;
  }
  
  private boolean b(Activity paramActivity, boolean paramBoolean, String paramString)
  {
    if (!nqi.b()) {
      nqi.a(paramActivity, paramActivity.getString(2131690318));
    }
    do
    {
      return false;
      if (!NetworkUtil.isNetworkAvailable())
      {
        nqi.a(paramActivity, paramActivity.getString(2131690390));
        return false;
      }
    } while (a(paramBoolean));
    if (a(paramActivity, paramBoolean, paramString))
    {
      QLog.e("AvGameManager", 1, "createAvGameRoom preCheckIsUserGamePlaying  true ");
      return false;
    }
    return true;
  }
  
  private void c()
  {
    AudioManager localAudioManager = (AudioManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext().getSystemService("audio");
    if (localAudioManager != null) {
      localAudioManager.requestAudioFocus(null, 3, 2);
    }
  }
  
  private boolean c()
  {
    if (this.jdField_a_of_type_Ansi != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AvGameManager", 2, "preCheckRealNameStatus remove observer");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ansi);
    }
    return ((ansg)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).c();
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public nho a()
  {
    if (this.jdField_a_of_type_Nho == null) {
      this.jdField_a_of_type_Nho = new nho(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_Nho;
  }
  
  public void a()
  {
    boolean bool = a();
    if (QLog.isColorLevel()) {
      QLog.d("AvGameManager", 2, "onEnterBackground isPlaying = " + bool);
    }
    if (bool) {
      AVGameUtilService.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManager", 2, "startStrangerMatchNotCheck " + paramInt);
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_stranger_match", true);
    c();
    AvGameLoadingActivity.a(true, paramInt, null, null, 0, localBundle);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      this.jdField_a_of_type_JavaLangString = null;
      AudioManager localAudioManager = (AudioManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext().getSystemService("audio");
      if (localAudioManager != null) {
        localAudioManager.abandonAudioFocus(null);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = paramInt;
      QLog.e("AvGameManager", 2, "setCurrentAvGameRoomInfo manager " + paramInt + " roomId" + paramString);
      return;
      if (paramInt == 2)
      {
        if (this.jdField_a_of_type_JavaLangString != null)
        {
          this.jdField_a_of_type_JavaLangString = null;
          QLog.e("AvGameManager", 2, "ac game process death in room playing");
        }
      }
      else {
        this.jdField_a_of_type_JavaLangString = paramString;
      }
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt == 1) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2))) {
      ThreadManager.getSubThreadHandler().post(new AvGameManager.6(this, paramString1, paramString2));
    }
    QLog.i("AvGameManager", 2, "notifySendMsg shareType " + paramInt + " friendUin" + paramString1 + "roomId " + paramString2);
  }
  
  public void a(Activity paramActivity)
  {
    int k = 1;
    if ((paramActivity == null) || (paramActivity.isFinishing()))
    {
      QLog.e("AvGameManager", 2, "on Permision Denied activity not exist");
      return;
    }
    Object localObject1;
    label37:
    Object localObject2;
    label50:
    int i;
    if ((paramActivity instanceof com.tencent.mobileqq.app.BaseActivity))
    {
      localObject1 = (com.tencent.mobileqq.app.BaseActivity)paramActivity;
      if (!(paramActivity instanceof mqq.app.BaseActivity)) {
        break label141;
      }
      localObject2 = (mqq.app.BaseActivity)paramActivity;
      if ((localObject1 == null) && (localObject2 == null)) {
        break label145;
      }
      if (localObject1 == null) {
        break label158;
      }
      if (((com.tencent.mobileqq.app.BaseActivity)localObject1).checkSelfPermission("android.permission.CAMERA") == 0) {
        break label147;
      }
      i = 1;
      label78:
      if (((com.tencent.mobileqq.app.BaseActivity)localObject1).checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label152;
      }
    }
    for (;;)
    {
      label89:
      if ((i != 0) && (k != 0)) {
        localObject1 = paramActivity.getResources().getString(2131690400);
      }
      for (;;)
      {
        localObject2 = new nde(this, paramActivity);
        bhdj.a(paramActivity, null, (String)localObject1, (DialogInterface.OnClickListener)localObject2, (DialogInterface.OnClickListener)localObject2, null);
        return;
        localObject1 = null;
        break label37;
        label141:
        localObject2 = null;
        break label50;
        label145:
        break;
        label147:
        i = 0;
        break label78;
        label152:
        k = 0;
        break label89;
        label158:
        if (localObject2 == null) {
          break label236;
        }
        if (((mqq.app.BaseActivity)localObject2).checkSelfPermission("android.permission.CAMERA") != 0) {}
        for (int j = 1;; j = 0)
        {
          i = j;
          if (((mqq.app.BaseActivity)localObject2).checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
            break;
          }
          k = 0;
          i = j;
          break;
        }
        if (i != 0) {
          localObject1 = paramActivity.getResources().getString(2131690399);
        } else {
          localObject1 = paramActivity.getResources().getString(2131690398);
        }
      }
      label236:
      i = 1;
    }
  }
  
  public void a(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManager", 2, "startStrangerMatch " + paramInt);
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_stranger_match", true);
    a(paramActivity, paramInt, null, 0, localBundle);
  }
  
  public void a(Activity paramActivity, int paramInt1, String paramString, int paramInt2)
  {
    QLog.i("AvGameManager", 1, "createAvGameRoom fType " + paramInt1 + " pUin" + paramString + " gType" + paramInt2);
    a(paramActivity, paramInt1, paramString, paramInt2, null);
  }
  
  public void a(Activity paramActivity, int paramInt1, String paramString, int paramInt2, Bundle paramBundle)
  {
    AVGameUtilService.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    if ((paramActivity == null) || (paramActivity.isFinishing())) {
      QLog.e("AvGameManager", 1, "createAvGameRoom activity finish");
    }
    do
    {
      return;
      if (!b(paramActivity, true, null))
      {
        QLog.e("AvGameManager", 1, "createAvGameRoom preCheckIfOkBeforeEnter finish");
        return;
      }
      if (!c())
      {
        if (paramInt1 == 9) {}
        for (int i = 3;; i = 2)
        {
          a(paramActivity, paramInt1, paramString, "", paramInt2, i);
          return;
        }
      }
      nqc.a().a("param_StepEntrance");
    } while (!nqi.a(paramActivity, new ndb(this, paramActivity, paramInt1, paramString, paramInt2, paramBundle)));
    c();
    AvGameLoadingActivity.a(true, paramInt1, paramString, null, paramInt2, paramBundle);
  }
  
  public void a(Activity paramActivity, int paramInt, String paramString1, String paramString2)
  {
    QLog.i("AvGameManager", 1, "joinAvGameRoom fType " + paramInt + " rId" + paramString1 + " sUin" + paramString2);
    if ((paramActivity == null) || (paramActivity.isFinishing())) {
      QLog.e("AvGameManager", 2, "joinAvGameRoom activity finish");
    }
    do
    {
      return;
      if (!b(paramActivity, false, paramString1))
      {
        QLog.e("AvGameManager", 2, "createAvGameRoom preCheckIfOkBeforeEnter finish");
        return;
      }
      if (TextUtils.isEmpty(paramString1))
      {
        QQToast.a(paramActivity, 2131690472, 0).a();
        QLog.e("AvGameManager", 2, "joinAvGameRoom with Empty room id");
        return;
      }
      if (!c())
      {
        if (paramInt == 6) {}
        for (int i = 3;; i = 1)
        {
          a(paramActivity, paramInt, paramString2, paramString1, 1, i);
          return;
        }
      }
      nqc.a().a("param_StepEntrance");
    } while (!nqi.a(paramActivity, new ndc(this, paramActivity, paramInt, paramString1, paramString2)));
    c();
    AvGameLoadingActivity.a(false, paramInt, paramString2, paramString1, 0, null);
  }
  
  public boolean a()
  {
    boolean bool2 = true;
    boolean bool1;
    if (!AVGameUtilService.a())
    {
      this.jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_JavaLangString = null;
      QLog.i("AvGameManager", 2, "isAVGameAlive false");
      bool1 = false;
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (b());
      bool1 = bool2;
    } while (this.jdField_a_of_type_JavaLangString != null);
    return false;
  }
  
  public boolean a(long paramLong1, long paramLong2, String paramString1, int paramInt1, String paramString2, int paramInt2, long paramLong3)
  {
    ndj localndj = (ndj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
    if (localndj != null)
    {
      localndj.a(paramLong1, paramLong2, paramString1, paramInt1, paramString2, paramInt2, paramLong3);
      return true;
    }
    return false;
  }
  
  public boolean a(Activity paramActivity)
  {
    if (!AVGameUtilService.a()) {
      QLog.i("AvGameManager", 2, "isAVGameAlive false");
    }
    while (this.jdField_a_of_type_JavaLangString == null) {
      return false;
    }
    a(paramActivity, false);
    return true;
  }
  
  public boolean a(String paramString)
  {
    ndj localndj = (ndj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
    if (localndj != null)
    {
      localndj.a(paramString);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, int paramInt1, int paramInt2)
  {
    ndj localndj = (ndj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
    if (localndj != null)
    {
      localndj.a(paramString, paramInt1, 10, paramInt2);
      return true;
    }
    return false;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    ndj localndj = (ndj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.AV_GAME_HANDLER);
    if (localndj != null)
    {
      localndj.a(paramString, paramLong);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    boolean bool = a();
    if (QLog.isColorLevel()) {
      QLog.d("AvGameManager", 2, "onEnterForeground isPlaying = " + bool);
    }
    if (bool) {
      AVGameUtilService.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    }
  }
  
  public void b(Activity paramActivity, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManager", 2, "startSurvivalGame " + paramInt);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_pk_type", paramInt);
    a(paramActivity, 10, null, 0, localBundle);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Int == 3;
  }
  
  public boolean b(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString);
    if (paramString != null) {}
    for (boolean bool = paramString.isAVGameOpen();; bool = false)
    {
      return bool;
      if (QLog.isColorLevel()) {
        QLog.e("AvGameManager", 2, "isAVGameOpen troopinfo is null");
      }
    }
  }
  
  public boolean c(String paramString)
  {
    paramString = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER)).a(paramString);
    if (paramString != null) {
      return paramString.isOnlyAllowManagerCreateAVGame();
    }
    if (QLog.isColorLevel()) {
      QLog.e("AvGameManager", 1, "isOnlyAllowManagerCreateAVGame troopinfo is null");
    }
    return false;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Nnf != null) {
      this.jdField_a_of_type_Nnf.b();
    }
    if (this.jdField_a_of_type_Ansi != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AvGameManager", 2, "onDestroy remove observer");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ansi);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ndm);
    if (this.jdField_a_of_type_Nho != null)
    {
      this.jdField_a_of_type_Nho.a();
      this.jdField_a_of_type_Nho = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ncz
 * JD-Core Version:    0.7.0.1
 */