package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.newnearby.INearbyCGIReporter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileSendMsgDialog$Companion;", "", "()V", "GET_GREET_INFO_CMD", "", "STATE_DATA_READY", "", "STATE_NOTHING_READY", "STATE_UI_AND_DATA_READY", "STATE_UI_READY", "TAG", "profileDisplayPanel", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileDisplayPanel;", "goToVerify", "", "report", "func", "Lkotlin/Function1;", "Lorg/json/JSONObject;", "Lkotlin/ExtensionFunctionType;", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NearbyProfileSendMsgDialog$Companion
{
  private final void a()
  {
    QLog.w("NearbyProfileSendMsgDialog", 1, "goToVerify");
    ((Companion)this).a((Function1)NearbyProfileSendMsgDialog.Companion.goToVerify.1.INSTANCE);
    Object localObject = (NearbyProfileDisplayPanel)NearbyProfileSendMsgDialog.a().get();
    if (localObject != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject, "profileDisplayPanel.get() ?: return");
      localObject = ((NearbyProfileDisplayPanel)localObject).e;
      Intent localIntent = new Intent((Context)localObject, QQBrowserActivity.class);
      localIntent.putExtra("url", "https://nearby.qq.com/qq/verify-identity/verify-identity.html?_bid=4602");
      ((NearbyPeopleProfileActivity)localObject).startActivity(localIntent);
    }
  }
  
  private final void a(Function1<? super JSONObject, Unit> paramFunction1)
  {
    for (;;)
    {
      try
      {
        localObject = (NearbyProfileDisplayPanel)NearbyProfileSendMsgDialog.a().get();
        if (localObject != null)
        {
          Intrinsics.checkExpressionValueIsNotNull(localObject, "profileDisplayPanel.get() ?: return");
          NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = ((NearbyProfileDisplayPanel)localObject).e;
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("opername", "now#nearby#datacard");
          QQAppInterface localQQAppInterface = localNearbyPeopleProfileActivity.app;
          Intrinsics.checkExpressionValueIsNotNull(localQQAppInterface, "activity.app");
          localJSONObject.put("fromuin", localQQAppInterface.getCurrentAccountUin());
          if (((NearbyProfileDisplayPanel)localObject).U == 4)
          {
            localObject = "0";
            localJSONObject.put("d4", localObject);
            localObject = localNearbyPeopleProfileActivity.app;
            Intrinsics.checkExpressionValueIsNotNull(localObject, "activity.app");
            localJSONObject.put("appid", String.valueOf(((QQAppInterface)localObject).getAppid()));
            localJSONObject.put("ts", String.valueOf(System.currentTimeMillis() / 1000));
            paramFunction1.invoke(localJSONObject);
            ((INearbyCGIReporter)QRoute.api(INearbyCGIReporter.class)).reportByJson(localJSONObject);
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramFunction1)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("report error: ");
        ((StringBuilder)localObject).append(paramFunction1);
        QLog.e("NearbyProfileSendMsgDialog", 1, ((StringBuilder)localObject).toString());
        return;
      }
      Object localObject = "1";
    }
  }
  
  public final void a(@NotNull FragmentManager paramFragmentManager, @NotNull NearbyProfileDisplayPanel paramNearbyProfileDisplayPanel)
  {
    Intrinsics.checkParameterIsNotNull(paramFragmentManager, "fragmentManager");
    Intrinsics.checkParameterIsNotNull(paramNearbyProfileDisplayPanel, "profileDisplayPanel");
    NearbyProfileSendMsgDialog.a(new WeakReference(paramNearbyProfileDisplayPanel));
    paramNearbyProfileDisplayPanel = paramFragmentManager.beginTransaction();
    paramFragmentManager = paramFragmentManager.findFragmentByTag("NearbyProfileSendMsgDialog");
    if (paramFragmentManager != null)
    {
      QLog.i("NearbyProfileSendMsgDialog", 1, "remove existing dialog");
      paramNearbyProfileDisplayPanel.remove(paramFragmentManager);
    }
    QLog.i("NearbyProfileSendMsgDialog", 1, "add new dialog");
    paramNearbyProfileDisplayPanel.add((Fragment)new NearbyProfileSendMsgDialog(), "NearbyProfileSendMsgDialog");
    paramNearbyProfileDisplayPanel.commitAllowingStateLoss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileSendMsgDialog.Companion
 * JD-Core Version:    0.7.0.1
 */