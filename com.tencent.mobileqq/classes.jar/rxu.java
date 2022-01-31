import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.widget.RelativeLayout;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ApolloItemBuilder;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.apollo.utils.ApolloDaoManager;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionData;
import com.tencent.mobileqq.data.ApolloFavActionData;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class rxu
  extends VasExtensionObserver
{
  public rxu(BaseChatPie paramBaseChatPie) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (this.a.jdField_a_of_type_AndroidContentContext == null) || (this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null)) {}
    Object localObject4;
    Object localObject1;
    do
    {
      return;
      if ((this.a.b != null) && (this.a.b.isShowing())) {
        this.a.b.dismiss();
      }
      localObject4 = new ApolloFavActionData();
      localObject1 = (HashMap)paramObject;
      paramObject = (String)((Map)localObject1).get("optFrom");
    } while ((TextUtils.isEmpty(paramObject)) || (!"actionAdd".equals(paramObject)));
    int m = Integer.parseInt((String)((Map)localObject1).get("id"));
    String str = (String)((Map)localObject1).get("actionText");
    if (!TextUtils.isEmpty((String)((Map)localObject1).get("textType"))) {}
    for (int i = Integer.parseInt((String)((Map)localObject1).get("textType"));; i = 0)
    {
      paramObject = (String)((Map)localObject1).get("audioId");
      if (!TextUtils.isEmpty(paramObject)) {}
      for (int j = Integer.parseInt(paramObject);; j = 0)
      {
        paramObject = (String)((Map)localObject1).get("audioTime");
        if (!TextUtils.isEmpty(paramObject)) {}
        for (float f = Float.parseFloat(paramObject);; f = 0.0F)
        {
          paramObject = (String)((Map)localObject1).get("isPlayDefultAudio");
          if (!TextUtils.isEmpty(paramObject)) {}
          for (int k = Integer.parseInt(paramObject);; k = 0)
          {
            paramObject = (ApolloDaoManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(154);
            boolean bool = ((ApolloManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152)).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c());
            ((ApolloFavActionData)localObject4).textType = i;
            ((ApolloFavActionData)localObject4).text = str;
            ((ApolloFavActionData)localObject4).acitonId = m;
            ((ApolloFavActionData)localObject4).audioId = j;
            ((ApolloFavActionData)localObject4).audioStartTime = f;
            ((ApolloFavActionData)localObject4).playOriginalAudio = k;
            if (paramBoolean)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.BaseChatPie", 2, "action auth success from add fav action=" + ((ApolloFavActionData)localObject4).toString());
              }
              ApolloItemBuilder.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_AndroidContentContext, (ApolloFavActionData)localObject4, this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo);
              return;
            }
            i = Integer.parseInt((String)((Map)localObject1).get("ret"));
            Object localObject2 = "";
            Object localObject3 = null;
            if (QLog.isColorLevel()) {
              QLog.d("Q.aio.BaseChatPie", 2, "action auth fail from fav add action=" + ((ApolloFavActionData)localObject4).toString() + " errcode = " + i);
            }
            ApolloActionData localApolloActionData = paramObject.a(m);
            switch (i)
            {
            default: 
              paramObject = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131438241);
              localObject1 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131438241);
              if (QLog.isColorLevel()) {
                QLog.d("Q.aio.BaseChatPie", 2, "unknown action auth errcode");
              }
              paramObject = DialogUtil.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity, 0, paramObject, (String)localObject1, this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131436751), (String)localObject2, (DialogInterface.OnClickListener)localObject3, new rxy(this));
              if (!this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.isFinishing()) {
                paramObject.show();
              }
              localObject1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
              localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString;
              i = ApolloUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
              localObject3 = "" + m;
              paramObject = str;
              if (TextUtils.isEmpty(str)) {
                paramObject = "0";
              }
              VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "add_action", (String)localObject2, i, 0, new String[] { localObject3, "", paramObject, String.valueOf(System.currentTimeMillis() / 1000L) });
              return;
            case 31004: 
              label575:
              paramObject = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131438227);
              localObject4 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131438228);
              if (localApolloActionData != null) {
                paramObject = String.format(paramObject, new Object[] { localApolloActionData.actionName });
              }
              break;
            }
            for (;;)
            {
              localObject2 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131438230);
              localObject3 = new rxv(this, m);
              VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "vip_alert_show", ApolloUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + m, "1" });
              localObject1 = paramObject;
              paramObject = localObject4;
              break label575;
              localObject2 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131438233);
              paramObject = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131438228);
              localObject1 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131438230);
              if (bool)
              {
                localObject2 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131438234);
                paramObject = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131438229);
                localObject1 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131438231);
              }
              if (localApolloActionData != null) {
                localObject2 = String.format((String)localObject2, new Object[] { Integer.valueOf(localApolloActionData.vipLevel), localApolloActionData.actionName });
              }
              for (;;)
              {
                localObject3 = new rxw(this, m, bool);
                localObject4 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
                j = ApolloUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int);
                if (bool) {}
                for (i = 0;; i = 1)
                {
                  VipUtils.a((AppInterface)localObject4, "cmshow", "Apollo", "level_alert_show", j, i, new String[] { "" + m, "1" });
                  localObject4 = localObject1;
                  localObject1 = localObject2;
                  localObject2 = localObject4;
                  break;
                }
                paramObject = (String)((Map)localObject1).get("content");
                if (TextUtils.isEmpty(paramObject)) {
                  paramObject = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131438237);
                }
                for (;;)
                {
                  localObject1 = (String)((Map)localObject1).get("url");
                  localObject1 = (String)localObject1 + "&actionid=" + m;
                  localObject4 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131438238);
                  localObject2 = this.a.jdField_a_of_type_AndroidWidgetRelativeLayout.getResources().getString(2131438238);
                  localObject3 = new rxx(this, (String)localObject1, m);
                  VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "activity_alert_show", ApolloUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, new String[] { "" + m, "1" });
                  localObject1 = paramObject;
                  paramObject = localObject4;
                  break label575;
                  QQToast.a(this.a.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 1, this.a.jdField_a_of_type_AndroidContentContext.getResources().getString(2131438218), 0).b(this.a.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131558448));
                  if (!QLog.isColorLevel()) {
                    break;
                  }
                  QLog.d("Q.aio.BaseChatPie", 2, "fav action network error");
                  return;
                }
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rxu
 * JD-Core Version:    0.7.0.1
 */