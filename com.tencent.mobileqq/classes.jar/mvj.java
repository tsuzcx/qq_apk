import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.support.v4.app.NotificationCompat.Builder;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.gaudio.BaseGaInvite;
import com.tencent.av.gaudio.GaInviteDialogActivity;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoInviteActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import mqq.app.MobileQQ;

public class mvj
{
  static mvj jdField_a_of_type_Mvj;
  int jdField_a_of_type_Int = 0;
  Notification jdField_a_of_type_AndroidAppNotification = null;
  Context jdField_a_of_type_AndroidContentContext = null;
  RemoteViews jdField_a_of_type_AndroidWidgetRemoteViews = null;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface = null;
  QQNotificationManager jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = null;
  Map<String, mvm> jdField_a_of_type_JavaUtilMap = new LinkedHashMap();
  mut jdField_a_of_type_Mut;
  mvm jdField_a_of_type_Mvm = null;
  boolean jdField_a_of_type_Boolean = false;
  final mvm b = new mvm(this, null);
  
  private mvj(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    if (this.jdField_a_of_type_AndroidContentContext == null) {
      this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApplication().getApplicationContext();
    }
    this.jdField_a_of_type_Mut = new mut(this.jdField_a_of_type_AndroidContentContext);
  }
  
  private Notification a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2, int paramInt, Bitmap paramBitmap, PendingIntent paramPendingIntent, List<mvl> paramList)
  {
    NotificationCompat.Builder localBuilder = new NotificationCompat.Builder(this.jdField_a_of_type_AndroidContentContext);
    localBuilder.setSmallIcon(paramInt);
    localBuilder.setContentTitle(paramString1);
    localBuilder.setContentText(paramString2);
    localBuilder.setWhen(System.currentTimeMillis());
    localBuilder.setLargeIcon(paramBitmap);
    localBuilder.setContentIntent(paramPendingIntent);
    if ((paramList != null) && (paramList.size() > 0))
    {
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramString2 = (mvl)paramString1.next();
        localBuilder.addAction(paramString2.jdField_a_of_type_Int, paramString2.jdField_a_of_type_JavaLangString, paramString2.jdField_a_of_type_AndroidAppPendingIntent);
      }
    }
    if (paramBoolean2)
    {
      localBuilder.setPriority(2);
      localBuilder.setFullScreenIntent(paramPendingIntent, true);
      localBuilder.setVibrate(mwk.a);
      this.jdField_a_of_type_AndroidAppNotification = localBuilder.build();
      paramString1 = this.jdField_a_of_type_AndroidAppNotification;
      paramString1.flags |= 0x2;
      paramString1 = this.jdField_a_of_type_AndroidAppNotification;
      paramString1.flags |= 0x20;
      if ((!mti.a()) || (!paramBoolean2)) {
        break label358;
      }
      paramString1 = this.jdField_a_of_type_AndroidAppNotification;
      paramString1.flags &= 0xFFFFFFF7;
      paramString1 = this.jdField_a_of_type_AndroidAppNotification;
      paramString1.flags |= 0x4;
      paramString1 = this.jdField_a_of_type_AndroidAppNotification;
      paramString1.flags |= 0x1;
      label253:
      if (Build.VERSION.SDK_INT >= 21)
      {
        if (!paramBoolean2) {
          break label409;
        }
        this.jdField_a_of_type_AndroidAppNotification.category = "call";
        paramString1 = this.jdField_a_of_type_AndroidAppNotification;
      }
    }
    for (paramString1.flags |= 0x80;; paramString1.flags &= 0xFFFFFF7F)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QAVNotification", 2, "useDefaultStyle flags: " + this.jdField_a_of_type_AndroidAppNotification.flags);
      }
      return this.jdField_a_of_type_AndroidAppNotification;
      localBuilder.setPriority(0);
      localBuilder.setFullScreenIntent(null, false);
      localBuilder.setVibrate(null);
      break;
      label358:
      paramString1 = this.jdField_a_of_type_AndroidAppNotification;
      paramString1.flags |= 0x8;
      paramString1 = this.jdField_a_of_type_AndroidAppNotification;
      paramString1.flags &= 0xFFFFFFFB;
      paramString1 = this.jdField_a_of_type_AndroidAppNotification;
      paramString1.flags &= 0xFFFFFFFE;
      break label253;
      label409:
      this.jdField_a_of_type_AndroidAppNotification.category = null;
      paramString1 = this.jdField_a_of_type_AndroidAppNotification;
    }
  }
  
  private String a(String paramString, int paramInt)
  {
    if (paramString == null) {}
    for (Object localObject1 = "";; localObject1 = paramString)
    {
      Object localObject2 = localObject1;
      if (((String)localObject1).length() >= paramInt)
      {
        localObject2 = localObject1;
        if (paramInt > 0)
        {
          localObject1 = paramString.toCharArray();
          paramString = String.valueOf(localObject1[0]);
          paramInt = 1;
          while (paramInt < 5)
          {
            paramString = paramString + String.valueOf(localObject1[paramInt]);
            paramInt += 1;
          }
          localObject2 = paramString + "...";
        }
      }
      return localObject2;
    }
  }
  
  private ArrayList<mvl> a(mvm parammvm, Intent paramIntent)
  {
    if ((parammvm == null) || (paramIntent == null)) {
      return null;
    }
    switch (parammvm.jdField_a_of_type_Int)
    {
    default: 
      return null;
    }
    ArrayList localArrayList = new ArrayList(2);
    paramIntent = new Intent(paramIntent);
    paramIntent.setAction("com.tencent.qav.notify.accept");
    paramIntent.putExtra("session_id", parammvm.jdField_a_of_type_JavaLangString);
    localArrayList.add(new mvl(2130841770, alud.a(2131709329), PendingIntent.getActivity(this.jdField_a_of_type_AndroidContentContext, 0, paramIntent, 134217728)));
    paramIntent = new Intent("com.tencent.qav.notify.refuse");
    paramIntent.putExtra("uin", this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
    paramIntent.putExtra("session_id", parammvm.jdField_a_of_type_JavaLangString);
    paramIntent.putExtra("notify_type", parammvm.jdField_a_of_type_Int);
    paramIntent.putExtra("uinType", parammvm.jdField_b_of_type_Int);
    localArrayList.add(new mvl(2130841772, alud.a(2131709328), PendingIntent.getBroadcast(this.jdField_a_of_type_AndroidContentContext, 0, paramIntent, 134217728)));
    return localArrayList;
  }
  
  public static mvj a(VideoAppInterface paramVideoAppInterface)
  {
    if ((jdField_a_of_type_Mvj == null) && (paramVideoAppInterface != null)) {}
    try
    {
      if (jdField_a_of_type_Mvj == null) {
        jdField_a_of_type_Mvj = new mvj(paramVideoAppInterface);
      }
      return jdField_a_of_type_Mvj;
    }
    finally {}
  }
  
  private mvm a(String paramString, int paramInt)
  {
    mvm localmvm = null;
    lid locallid = lfb.a().c(paramString);
    if (locallid != null)
    {
      localmvm = new mvm(this, null);
      localmvm.jdField_a_of_type_JavaLangString = paramString;
      localmvm.jdField_c_of_type_Int = paramInt;
      if ((locallid.jdField_d_of_type_Int == 1) || (locallid.jdField_d_of_type_Int == 2))
      {
        localmvm.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(locallid.i, locallid.jdField_d_of_type_JavaLangString, locallid.f);
        localmvm.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(locallid.i, locallid.jdField_d_of_type_JavaLangString, null, true, true);
        if (locallid.jdField_d_of_type_Int == 1)
        {
          localmvm.jdField_a_of_type_Int = 47;
          this.jdField_a_of_type_JavaUtilMap.put(paramString, localmvm);
          if (!QLog.isColorLevel()) {
            return localmvm;
          }
          QLog.i("QAVNotification", 2, "createNotifyData, we create one data, data[" + localmvm + "]");
        }
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        return localmvm;
        localmvm.jdField_a_of_type_Int = 42;
        continue;
        String str;
        if (locallid.J)
        {
          str = String.valueOf(locallid.g);
          localmvm.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(locallid.i, str, null);
          localmvm.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(locallid.i, str, null, true, true);
          localmvm.jdField_a_of_type_Int = 48;
        }
        else
        {
          str = String.valueOf(locallid.g);
          localmvm.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(locallid.i, str, null);
          localmvm.jdField_a_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(locallid.i, str, null, true, true);
          if (locallid.jdField_d_of_type_Int == 3) {
            localmvm.jdField_a_of_type_Int = 62;
          } else {
            localmvm.jdField_a_of_type_Int = 63;
          }
        }
      }
    }
    QLog.i("QAVNotification", 2, "createNotifyData, no sessionInfo, id[" + paramString + "]");
    return null;
    return localmvm;
  }
  
  public static void a(Context paramContext)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QAVNotification", 2, "cancelNotificationForce", new Throwable());
    }
    QQNotificationManager.getInstance().cancel("QAVNotification", 235);
  }
  
  private void a(mvm parammvm, boolean paramBoolean)
  {
    a(parammvm, paramBoolean, null, false);
  }
  
  private void a(mvm parammvm, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    a(parammvm, paramBoolean1, paramString, paramBoolean2, false);
  }
  
  private void a(mvm parammvm, boolean paramBoolean1, String paramString, boolean paramBoolean2, boolean paramBoolean3)
  {
    boolean bool1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().q();
    boolean bool2 = e(parammvm.jdField_a_of_type_JavaLangString);
    boolean bool3 = d(parammvm.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(200);
      ((StringBuilder)localObject1).append("updateNotification, data=").append(parammvm).append(", create=").append(paramBoolean1).append(", time=").append(paramString).append(", invite=").append(paramBoolean2).append(", fullScreen=").append(paramBoolean3).append(", isSessionCanNotify=").append(bool3);
      QLog.d("QAVNotification", 2, ((StringBuilder)localObject1).toString());
    }
    if ((bool1) || ((!paramBoolean2) && (!bool2)) || (!bool3)) {}
    do
    {
      do
      {
        return;
        if (!TextUtils.isEmpty(paramString)) {
          a(parammvm);
        }
        paramBoolean2 = mti.b(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin());
        if (QLog.isColorLevel()) {
          QLog.w("QAVNotification", 2, "updateNotification avCallBtnState[" + paramBoolean2 + "]");
        }
      } while ((!paramBoolean2) && (TextUtils.isEmpty(paramString)) && (!a(parammvm)));
      paramBoolean2 = mwk.a(BaseApplicationImpl.getContext());
      if (QLog.isColorLevel()) {
        QLog.w("QAVNotification", 2, "updateNotification canDisturb[" + paramBoolean2 + "]");
      }
    } while ((!paramBoolean2) && (TextUtils.isEmpty(paramString)) && (!a(parammvm)));
    PendingIntent localPendingIntent = null;
    Object localObject4 = "";
    Object localObject5 = "";
    int j = 0;
    StringBuilder localStringBuilder = null;
    paramString = (String)localObject5;
    Object localObject1 = localObject4;
    Object localObject2 = localPendingIntent;
    int i = j;
    Object localObject3 = localStringBuilder;
    switch (parammvm.jdField_a_of_type_Int)
    {
    default: 
      localObject3 = localStringBuilder;
      i = j;
      localObject2 = localPendingIntent;
      localObject1 = localObject4;
      paramString = (String)localObject5;
    case 49: 
    case 50: 
    case 51: 
    case 52: 
    case 53: 
    case 54: 
    case 58: 
    case 59: 
    case 60: 
      j = lid.Y;
      localPendingIntent = null;
      if (localObject2 != null)
      {
        ((Intent)localObject2).putExtra("MultiAVType", j);
        ((Intent)localObject2).putExtra("Fromwhere", "AVNotification");
        ((Intent)localObject2).addFlags(4194304);
        ((Intent)localObject2).addFlags(262144);
        ((Intent)localObject2).putExtra("param_notifyid", 235);
        ((Intent)localObject2).putExtra("fullscreen", paramBoolean3);
        if ((parammvm.jdField_a_of_type_Int != 40) && (parammvm.jdField_a_of_type_Int != 45) && (parammvm.jdField_a_of_type_Int != 43)) {
          ((Intent)localObject2).addFlags(268435456);
        }
        localPendingIntent = PendingIntent.getActivity(this.jdField_a_of_type_AndroidContentContext, 0, (Intent)localObject2, 134217728);
      }
      if (j == 2) {
        localObject1 = ((String)localObject1).replace(this.jdField_a_of_type_AndroidContentContext.getString(2131720917), this.jdField_a_of_type_AndroidContentContext.getString(2131720918));
      }
      break;
    }
    for (;;)
    {
      if (j == 2) {
        paramString = paramString.replace(this.jdField_a_of_type_AndroidContentContext.getString(2131720917), this.jdField_a_of_type_AndroidContentContext.getString(2131720918));
      }
      for (;;)
      {
        localObject4 = a(parammvm, (Intent)localObject2);
        if (QLog.isColorLevel())
        {
          localObject5 = new StringBuilder(300);
          localStringBuilder = ((StringBuilder)localObject5).append("updateNotification title: ").append((String)localObject1).append(", state: ").append(paramString).append(", id: ").append(parammvm.jdField_c_of_type_JavaLangString).append(", sessionId: ").append(parammvm.jdField_a_of_type_JavaLangString).append(", name: ").append(parammvm.jdField_b_of_type_JavaLangString).append(", type: ").append(parammvm.jdField_a_of_type_Int).append(", avType: ").append(j).append(", actions: ");
          if (localObject4 != null) {
            break label2148;
          }
        }
        label2148:
        for (localObject2 = "null";; localObject2 = Integer.valueOf(((ArrayList)localObject4).size()))
        {
          localStringBuilder.append(localObject2).append(", time: ").append(System.currentTimeMillis());
          QLog.d("QAVNotification", 2, ((StringBuilder)localObject5).toString());
          try
          {
            paramString = a(paramBoolean1, paramBoolean3, (String)localObject1, paramString, i, (Bitmap)localObject3, localPendingIntent, (List)localObject4);
            if (Build.VERSION.SDK_INT >= 26) {
              QQNotificationManager.addChannelIfNeed(paramString, "CHANNEL_ID_SHOW_BADGE");
            }
            if (paramBoolean1) {
              this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(true, paramString);
            }
            if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager == null) {
              this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = QQNotificationManager.getInstance();
            }
            this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.notify("QAVNotification", 235, paramString);
            parammvm.jdField_a_of_type_Boolean = false;
            mvm.a(this.b, parammvm);
            this.jdField_a_of_type_Mvm = parammvm;
            this.jdField_a_of_type_Boolean = true;
            return;
          }
          catch (Throwable parammvm)
          {
            QLog.e("QAVNotification", 1, "updateNotification fail.", parammvm);
            return;
          }
          localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
          ((Intent)localObject2).putExtra("isDoubleVideoMeeting", true);
          ((Intent)localObject2).putExtra("sessionType", parammvm.jdField_c_of_type_Int);
          ((Intent)localObject2).putExtra("GroupId", parammvm.jdField_c_of_type_JavaLangString);
          localObject1 = parammvm.jdField_b_of_type_JavaLangString;
          if (parammvm.jdField_c_of_type_Int == 4) {}
          for (paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131696165);; paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131696159))
          {
            i = 2130841957;
            localObject3 = parammvm.jdField_a_of_type_AndroidGraphicsBitmap;
            break;
          }
          localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, VideoInviteActivity.class);
          localObject1 = parammvm.jdField_b_of_type_JavaLangString;
          paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131721338);
          i = 2130841957;
          localObject3 = parammvm.jdField_a_of_type_AndroidGraphicsBitmap;
          break;
          localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, VideoInviteActivity.class);
          ((Intent)localObject2).addFlags(4194304);
          ((Intent)localObject2).addFlags(262144);
          localObject1 = parammvm.jdField_b_of_type_JavaLangString;
          paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131696164);
          i = 2130841786;
          localObject3 = parammvm.jdField_a_of_type_AndroidGraphicsBitmap;
          break;
          localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
          ((Intent)localObject2).putExtra("sessionType", parammvm.jdField_c_of_type_Int);
          ((Intent)localObject2).putExtra("uin", parammvm.jdField_c_of_type_JavaLangString);
          localObject1 = parammvm.jdField_b_of_type_JavaLangString;
          paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131695840);
          i = 2130841957;
          localObject3 = parammvm.jdField_a_of_type_AndroidGraphicsBitmap;
          break;
          localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, GaInviteDialogActivity.class);
          ((Intent)localObject2).putExtra("sessionType", parammvm.jdField_c_of_type_Int);
          ((Intent)localObject2).putExtra("uinType", parammvm.jdField_b_of_type_Int);
          BaseGaInvite.a((Intent)localObject2, "updateNotification");
          localObject1 = parammvm.jdField_b_of_type_JavaLangString;
          if (TextUtils.isEmpty(parammvm.jdField_d_of_type_JavaLangString)) {}
          for (paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131696136);; paramString = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131696137), new Object[] { a(parammvm.jdField_d_of_type_JavaLangString, 7) }))
          {
            i = 2130841786;
            localObject3 = parammvm.jdField_a_of_type_AndroidGraphicsBitmap;
            break;
          }
          localObject2 = mvn.a(this.jdField_a_of_type_AndroidContentContext, parammvm.jdField_a_of_type_JavaLangString);
          localObject1 = parammvm.jdField_b_of_type_JavaLangString;
          if (TextUtils.isEmpty(parammvm.jdField_d_of_type_JavaLangString)) {}
          for (paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131696136);; paramString = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131696137), new Object[] { a(parammvm.jdField_d_of_type_JavaLangString, 7) }))
          {
            i = 2130841786;
            localObject3 = parammvm.jdField_a_of_type_AndroidGraphicsBitmap;
            break;
          }
          localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
          ((Intent)localObject2).putExtra("sessionType", parammvm.jdField_c_of_type_Int);
          ((Intent)localObject2).putExtra("uin", parammvm.jdField_c_of_type_JavaLangString);
          localObject1 = parammvm.jdField_b_of_type_JavaLangString;
          paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131696165);
          i = 2130841957;
          localObject3 = parammvm.jdField_a_of_type_AndroidGraphicsBitmap;
          break;
          localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
          ((Intent)localObject2).putExtra("sessionType", parammvm.jdField_c_of_type_Int);
          ((Intent)localObject2).putExtra("GroupId", parammvm.jdField_c_of_type_JavaLangString);
          localObject1 = parammvm.jdField_b_of_type_JavaLangString;
          paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131695840);
          i = 2130841786;
          localObject3 = parammvm.jdField_a_of_type_AndroidGraphicsBitmap;
          break;
          localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
          ((Intent)localObject2).putExtra("sessionType", parammvm.jdField_c_of_type_Int);
          ((Intent)localObject2).putExtra("GroupId", parammvm.jdField_c_of_type_JavaLangString);
          localObject1 = parammvm.jdField_b_of_type_JavaLangString;
          paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131696159);
          i = 2130841786;
          localObject3 = parammvm.jdField_a_of_type_AndroidGraphicsBitmap;
          break;
          localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
          ((Intent)localObject2).putExtra("GroupId", parammvm.jdField_c_of_type_JavaLangString);
          ((Intent)localObject2).putExtra("Type", 2);
          ((Intent)localObject2).putExtra("sessionType", 3);
          ((Intent)localObject2).putExtra("uinType", parammvm.jdField_b_of_type_Int);
          ((Intent)localObject2).putExtra("sessionType", parammvm.jdField_c_of_type_Int);
          localObject1 = parammvm.jdField_b_of_type_JavaLangString;
          paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131696032);
          i = 2130841786;
          localObject3 = parammvm.jdField_a_of_type_AndroidGraphicsBitmap;
          break;
          localObject2 = mvn.b(this.jdField_a_of_type_AndroidContentContext, parammvm.jdField_a_of_type_JavaLangString);
          localObject1 = parammvm.jdField_b_of_type_JavaLangString;
          paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131690319);
          i = 2130841786;
          localObject3 = parammvm.jdField_a_of_type_AndroidGraphicsBitmap;
          break;
          localObject2 = mvn.b(this.jdField_a_of_type_AndroidContentContext, parammvm.jdField_a_of_type_JavaLangString);
          localObject1 = parammvm.jdField_b_of_type_JavaLangString;
          paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131721338);
          i = 2130841957;
          localObject3 = parammvm.jdField_a_of_type_AndroidGraphicsBitmap;
          break;
          localObject2 = mvn.b(this.jdField_a_of_type_AndroidContentContext, parammvm.jdField_a_of_type_JavaLangString);
          localObject1 = parammvm.jdField_b_of_type_JavaLangString;
          if (TextUtils.isEmpty(parammvm.jdField_d_of_type_JavaLangString)) {}
          for (paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131696136);; paramString = String.format(this.jdField_a_of_type_AndroidContentContext.getString(2131696137), new Object[] { a(parammvm.jdField_d_of_type_JavaLangString, 7) }))
          {
            i = 2130841786;
            localObject3 = parammvm.jdField_a_of_type_AndroidGraphicsBitmap;
            break;
          }
          localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
          ((Intent)localObject2).putExtra("GroupId", parammvm.jdField_c_of_type_JavaLangString);
          ((Intent)localObject2).putExtra("Type", 2);
          ((Intent)localObject2).putExtra("sessionType", 3);
          ((Intent)localObject2).putExtra("uinType", parammvm.jdField_b_of_type_Int);
          ((Intent)localObject2).putExtra("sessionType", parammvm.jdField_c_of_type_Int);
          localObject1 = parammvm.jdField_b_of_type_JavaLangString;
          paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131696159);
          i = 2130841786;
          localObject3 = parammvm.jdField_a_of_type_AndroidGraphicsBitmap;
          break;
          localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, AVActivity.class);
          ((Intent)localObject2).putExtra("GroupId", parammvm.jdField_c_of_type_JavaLangString);
          ((Intent)localObject2).putExtra("Type", 2);
          ((Intent)localObject2).putExtra("sessionType", 3);
          ((Intent)localObject2).putExtra("uinType", parammvm.jdField_b_of_type_Int);
          ((Intent)localObject2).putExtra("sessionType", parammvm.jdField_c_of_type_Int);
          localObject1 = parammvm.jdField_b_of_type_JavaLangString;
          paramString = this.jdField_a_of_type_AndroidContentContext.getString(2131696165);
          i = 2130841786;
          localObject3 = parammvm.jdField_a_of_type_AndroidGraphicsBitmap;
          break;
        }
      }
    }
  }
  
  private boolean a(mvm parammvm)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((this.jdField_a_of_type_Int != 2) || (a()))
    {
      bool1 = bool2;
      if (a())
      {
        bool1 = bool2;
        if (!mvm.a(this.b, parammvm)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("QAVNotification", 4, "isNeedNotificationAnyWay, flag[" + this.jdField_a_of_type_Int + "], active[" + a() + "], come[" + parammvm + "], last[" + this.b + "], need[" + bool1 + "]");
    }
    return bool1;
  }
  
  private boolean c(String paramString)
  {
    if ((this.jdField_a_of_type_Mvm == null) || (!this.jdField_a_of_type_Boolean)) {}
    while (!TextUtils.equals(paramString, this.jdField_a_of_type_Mvm.jdField_a_of_type_JavaLangString)) {
      return false;
    }
    return true;
  }
  
  private boolean d(String paramString)
  {
    boolean bool2 = false;
    paramString = lfb.a().c(paramString);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      bool1 = bool2;
      if (!paramString.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private boolean e(String paramString)
  {
    boolean bool2 = false;
    paramString = lfb.a().c(paramString);
    boolean bool1 = bool2;
    if (paramString != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAVNotification", 2, "isSessionIdVisible sessionInfo.sessionStatus = " + paramString.jdField_c_of_type_Int);
      }
      bool1 = bool2;
      if (paramString.jdField_c_of_type_Int != 3) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void a()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAVNotification", 2, "cancelNotificationEx mIsActive: " + this.jdField_a_of_type_Boolean, new Throwable());
      }
      if (this.jdField_a_of_type_Boolean)
      {
        if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
          this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("QAVNotification", 235);
        }
        this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(false, null);
        this.jdField_a_of_type_Mvm = null;
        this.jdField_a_of_type_Boolean = false;
        this.jdField_a_of_type_JavaUtilMap.clear();
        this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager = null;
        this.jdField_a_of_type_AndroidAppNotification = null;
        this.jdField_a_of_type_AndroidWidgetRemoteViews = null;
      }
      return;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QAVNotification", 2, "updateFlag, flag[" + paramInt + "]");
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(String paramString)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("QAVNotification", 2, "cancelNotification mIsActive: " + this.jdField_a_of_type_Boolean + ", sessionId:" + paramString, new Throwable());
        }
        if (c(paramString))
        {
          if (this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager != null) {
            this.jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager.cancel("QAVNotification", 235);
          }
          this.jdField_a_of_type_JavaUtilMap.remove(paramString);
          this.jdField_a_of_type_Mvm = null;
          this.jdField_a_of_type_Boolean = false;
          mvm.a(this.b, null);
          if (!this.jdField_a_of_type_JavaUtilMap.isEmpty())
          {
            paramString = this.jdField_a_of_type_JavaUtilMap.values().iterator();
            if (paramString.hasNext()) {
              a((mvm)paramString.next(), true);
            }
            return;
          }
          a(0);
          this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(false, null);
          continue;
        }
        this.jdField_a_of_type_JavaUtilMap.remove(paramString);
      }
      finally {}
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    for (;;)
    {
      boolean bool2;
      boolean bool3;
      mvm localmvm2;
      try
      {
        mvm localmvm3 = (mvm)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
        mvm localmvm1 = localmvm3;
        if (localmvm3 == null)
        {
          int i = this.jdField_a_of_type_Int;
          localmvm1 = localmvm3;
          if (i != 2) {}
        }
        boolean bool1;
        try
        {
          localmvm1 = a(paramString1, paramInt);
          bool1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().q();
          bool2 = e(paramString1);
          bool3 = c(paramString1);
          boolean bool4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().b();
          if (QLog.isColorLevel()) {
            QLog.w("QAVNotification", 2, "updateNotification, sessionId[" + paramString1 + "], mIsActive[" + this.jdField_a_of_type_Boolean + "], SessionType[" + paramInt + "], isNearbyVideoChat[" + bool1 + "], isSessionIdVisible[" + bool2 + "], isActiveSession[" + bool3 + "], isGameMode[" + bool4 + "], time[" + paramString2 + "], data[" + localmvm1 + "]");
          }
          if (bool4)
          {
            bool4 = a(localmvm1);
            if (!bool4) {
              return;
            }
          }
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
          QLog.i("QAVNotification", 1, "updateNotification exception", localThrowable);
          localmvm2 = localmvm3;
          continue;
        }
        if (bool1) {
          continue;
        }
      }
      finally {}
      if ((bool2) && (localmvm2 != null) && ((bool3) || (a(localmvm2))))
      {
        paramString1 = lfb.a().c(paramString1);
        if (((paramString1 == null) || (paramString1.a.jdField_b_of_type_Int != 4)) && (((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_AndroidAppNotification != null)) || (a(localmvm2)))) {
          a(localmvm2, true, paramString2, false);
        }
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("QAVNotification", 2, "changeNotificationSessionId " + paramString1 + " to " + paramString2);
      }
      mvm localmvm = (mvm)this.jdField_a_of_type_JavaUtilMap.get(paramString1);
      if (localmvm != null)
      {
        this.jdField_a_of_type_JavaUtilMap.remove(paramString1);
        this.jdField_a_of_type_JavaUtilMap.put(paramString2, localmvm);
      }
      return;
    }
    finally {}
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      a(paramString1, paramString2, paramBitmap, paramString3, paramInt1, paramInt2, paramInt3, null);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public void a(String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    for (;;)
    {
      try
      {
        boolean bool1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().q();
        boolean bool2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().a().i();
        boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().b();
        boolean bool4 = c(paramString1);
        if (QLog.isColorLevel()) {
          QLog.w("QAVNotification", 2, "addNotification, sessionId[" + paramString1 + "], name[" + paramString2 + "], id[" + paramString3 + "], type[" + paramInt1 + "], uinType[" + paramInt2 + "], sessionType[" + paramInt3 + "], isNearbyVideoChat[" + bool1 + "], isActiveSession[" + bool4 + "], isBeInviting[" + bool2 + "], isGameMode[" + bool3 + "]");
        }
        if ((bool1) || ((bool2) && (bool3))) {
          return;
        }
        if (TextUtils.isEmpty(paramString1)) {
          continue;
        }
        if (bool4)
        {
          mvm localmvm = this.jdField_a_of_type_Mvm;
          localmvm.jdField_a_of_type_JavaLangString = paramString1;
          localmvm.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
          localmvm.jdField_a_of_type_Int = paramInt1;
          localmvm.jdField_c_of_type_JavaLangString = paramString3;
          localmvm.jdField_b_of_type_JavaLangString = paramString2;
          localmvm.jdField_b_of_type_Int = paramInt2;
          localmvm.jdField_c_of_type_Int = paramInt3;
          localmvm.jdField_d_of_type_JavaLangString = paramString4;
          a(localmvm, false);
          continue;
        }
        paramString2 = new mvm(this, paramString1, paramString2, paramBitmap, paramString3, paramInt1, paramInt2, paramInt3, null);
      }
      finally {}
      this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
      a(paramString2, true);
    }
  }
  
  public void a(mvm parammvm)
  {
    int i = 48;
    if (parammvm == null) {}
    for (;;)
    {
      return;
      lid locallid = lfb.a().c(parammvm.jdField_a_of_type_JavaLangString);
      if (locallid != null)
      {
        int j = parammvm.jdField_a_of_type_Int;
        if (locallid.J) {
          if (!locallid.m()) {}
        }
        while (parammvm.jdField_a_of_type_Int != i)
        {
          if (QLog.isColorLevel()) {
            QLog.i("QAVNotification", 2, "checkAndUpdateNotifyData, pre[" + parammvm.jdField_a_of_type_Int + "], cur[" + i + "], info[" + locallid + "]");
          }
          parammvm.jdField_a_of_type_Int = i;
          return;
          if (locallid.l())
          {
            parammvm.jdField_c_of_type_Int = locallid.jdField_d_of_type_Int;
            continue;
            if (locallid.q())
            {
              if (locallid.l())
              {
                if (locallid.jdField_d_of_type_Int == 3)
                {
                  i = 62;
                  continue;
                }
                i = 63;
              }
            }
            else if (locallid.k())
            {
              if (locallid.jdField_d_of_type_Int == 1)
              {
                i = 47;
                continue;
              }
              i = 42;
              continue;
            }
          }
          i = j;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    for (;;)
    {
      try
      {
        boolean bool1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().q();
        boolean bool2 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().b();
        boolean bool3 = c(paramString1);
        QLog.w("QAVNotification", 1, "addInviteNotification, sessionId[" + paramString1 + "], name[" + paramString2 + "], id[" + paramString3 + "], type[" + paramInt1 + "], uinType[" + paramInt2 + "], sessionType[" + paramInt3 + "], isNearbyVideoChat[" + bool1 + "], isActiveSession[" + bool3 + "], isGameMode[" + bool2 + "]");
        if ((bool1) || (bool2)) {
          return;
        }
        if (TextUtils.isEmpty(paramString1)) {
          continue;
        }
        if (!bool3) {
          break label269;
        }
        mvm localmvm = this.jdField_a_of_type_Mvm;
        localmvm.jdField_a_of_type_JavaLangString = paramString1;
        localmvm.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
        localmvm.jdField_a_of_type_Int = paramInt1;
        localmvm.jdField_c_of_type_JavaLangString = paramString3;
        localmvm.jdField_b_of_type_Int = paramInt2;
        localmvm.jdField_c_of_type_Int = paramInt3;
        localmvm.jdField_b_of_type_JavaLangString = paramString2;
        localmvm.jdField_d_of_type_JavaLangString = null;
        if (paramBoolean)
        {
          a(localmvm, true, null, true);
          continue;
        }
        a(localmvm, false, null, true);
      }
      finally {}
      continue;
      label269:
      paramString2 = new mvm(this, paramString1, paramString2, paramBitmap, paramString3, paramInt1, paramInt2, paramInt3, null);
      this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
      a(paramString2, true, null, true);
    }
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2, Bitmap paramBitmap, String paramString3, int paramInt1, int paramInt2, int paramInt3, String paramString4)
  {
    for (;;)
    {
      try
      {
        boolean bool3 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().q();
        boolean bool4 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().b();
        boolean bool5 = c(paramString1);
        QLog.d("QAVNotification", 1, String.format("addFullScreenInviteNotification isNearbyVideoChat=%s isGameMode=%s isActiveSession=%s", new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool4), Boolean.valueOf(bool5) }));
        boolean bool1;
        mvm localmvm;
        if ((!bool3) && (!bool4))
        {
          bool1 = true;
          boolean bool2 = bool1;
          if (!bool1)
          {
            bool2 = bool1;
            if (mti.a()) {
              bool2 = true;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.i("QAVNotification", 2, "addFullScreenInviteNotification needNotify[" + bool2 + "], isGameMode[" + bool4 + "], isNearbyVideoChat[" + bool3 + "], isUseCompatMode[" + mti.a() + "]");
          }
          if ((bool2) && (!TextUtils.isEmpty(paramString1)))
          {
            if (!bool5) {
              break label299;
            }
            localmvm = this.jdField_a_of_type_Mvm;
            localmvm.jdField_a_of_type_JavaLangString = paramString1;
            localmvm.jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
            localmvm.jdField_a_of_type_Int = paramInt1;
            localmvm.jdField_c_of_type_JavaLangString = paramString3;
            localmvm.jdField_b_of_type_Int = paramInt2;
            localmvm.jdField_c_of_type_Int = paramInt3;
            localmvm.jdField_b_of_type_JavaLangString = paramString2;
            localmvm.jdField_d_of_type_JavaLangString = paramString4;
            if (!paramBoolean) {
              continue;
            }
            a(localmvm, true, null, true, true);
          }
        }
        else
        {
          bool1 = false;
          continue;
        }
        a(localmvm, false, null, true, true);
        continue;
        paramString2 = new mvm(this, paramString1, paramString2, paramBitmap, paramString3, paramInt1, paramInt2, paramInt3, paramString4);
      }
      finally {}
      label299:
      this.jdField_a_of_type_JavaUtilMap.put(paramString1, paramString2);
      a(paramString2, true, null, true, true);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  /* Error */
  public boolean a(String paramString)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: aload_0
    //   3: monitorenter
    //   4: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +42 -> 49
    //   10: ldc 183
    //   12: iconst_2
    //   13: new 185	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   20: ldc_w 744
    //   23: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_0
    //   27: getfield 35	mvj:jdField_a_of_type_Boolean	Z
    //   30: invokevirtual 406	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   33: ldc_w 623
    //   36: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_1
    //   40: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 416	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: aload_1
    //   51: invokespecial 625	mvj:c	(Ljava/lang/String;)Z
    //   54: ifeq +44 -> 98
    //   57: aload_0
    //   58: getfield 37	mvj:jdField_a_of_type_Mvm	Lmvm;
    //   61: iconst_1
    //   62: putfield 523	mvm:jdField_a_of_type_Boolean	Z
    //   65: aload_0
    //   66: getfield 27	mvj:jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager	Lcom/tencent/commonsdk/util/notification/QQNotificationManager;
    //   69: ifnull +15 -> 84
    //   72: aload_0
    //   73: getfield 27	mvj:jdField_a_of_type_ComTencentCommonsdkUtilNotificationQQNotificationManager	Lcom/tencent/commonsdk/util/notification/QQNotificationManager;
    //   76: ldc 183
    //   78: sipush 235
    //   81: invokevirtual 377	com/tencent/commonsdk/util/notification/QQNotificationManager:cancel	(Ljava/lang/String;I)V
    //   84: aload_0
    //   85: aconst_null
    //   86: putfield 37	mvj:jdField_a_of_type_Mvm	Lmvm;
    //   89: aload_0
    //   90: iconst_0
    //   91: putfield 35	mvj:jdField_a_of_type_Boolean	Z
    //   94: aload_0
    //   95: monitorexit
    //   96: iload_2
    //   97: ireturn
    //   98: iconst_0
    //   99: istore_2
    //   100: goto -6 -> 94
    //   103: astore_1
    //   104: aload_0
    //   105: monitorexit
    //   106: aload_1
    //   107: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	108	0	this	mvj
    //   0	108	1	paramString	String
    //   1	99	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   4	49	103	finally
    //   49	84	103	finally
    //   84	94	103	finally
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 42	mvj:jdField_a_of_type_JavaUtilMap	Ljava/util/Map;
    //   6: aload_1
    //   7: invokeinterface 645 2 0
    //   12: checkcast 44	mvm
    //   15: astore_3
    //   16: invokestatic 181	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +58 -> 77
    //   22: ldc 183
    //   24: iconst_1
    //   25: new 185	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   32: ldc_w 746
    //   35: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: aload_1
    //   39: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: ldc_w 653
    //   45: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: getfield 35	mvj:jdField_a_of_type_Boolean	Z
    //   52: invokevirtual 406	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   55: ldc_w 667
    //   58: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: aload_3
    //   62: invokevirtual 346	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   65: ldc_w 348
    //   68: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: invokevirtual 199	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   74: invokestatic 432	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   77: aload_3
    //   78: ifnull +29 -> 107
    //   81: aload_3
    //   82: getfield 523	mvm:jdField_a_of_type_Boolean	Z
    //   85: ifeq +22 -> 107
    //   88: aload_0
    //   89: getfield 35	mvj:jdField_a_of_type_Boolean	Z
    //   92: ifne +15 -> 107
    //   95: aload_0
    //   96: aload_3
    //   97: iconst_1
    //   98: invokespecial 640	mvj:a	(Lmvm;Z)V
    //   101: iconst_1
    //   102: istore_2
    //   103: aload_0
    //   104: monitorexit
    //   105: iload_2
    //   106: ireturn
    //   107: iconst_0
    //   108: istore_2
    //   109: goto -6 -> 103
    //   112: astore_1
    //   113: aload_0
    //   114: monitorexit
    //   115: aload_1
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	mvj
    //   0	117	1	paramString	String
    //   102	7	2	bool	boolean
    //   15	82	3	localmvm	mvm
    // Exception table:
    //   from	to	target	type
    //   2	77	112	finally
    //   81	101	112	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mvj
 * JD-Core Version:    0.7.0.1
 */