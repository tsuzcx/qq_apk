package com.tencent.mobileqq.nearby.profilecard;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.nearby.trpc_nearby_profile.nearby_profile.nearbyProfile.GetGreetReq;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileSendMsgDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/view/View$OnClickListener;", "()V", "contentsToSend", "", "", "dialogShowTime", "", "isLoadingContent", "", "leftCount", "", "leftSendMsgContentTv", "Landroid/widget/TextView;", "sendMsgLayout", "Landroid/view/ViewGroup;", "state", "goToSendMsg", "", "content", "loadContent", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "setContentUI", "showCantSendMsgDialog", "Companion", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NearbyProfileSendMsgDialog
  extends DialogFragment
  implements View.OnClickListener
{
  public static final NearbyProfileSendMsgDialog.Companion a = new NearbyProfileSendMsgDialog.Companion(null);
  private static WeakReference<NearbyProfileDisplayPanel> i = new WeakReference(null);
  private long b;
  private ViewGroup c;
  private TextView d;
  private int e;
  private final List<String> f = (List)new LinkedList();
  private int g;
  private boolean h;
  private HashMap j;
  
  private final void a(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("goToSendMsg: content=");
    ((StringBuilder)localObject1).append(paramString);
    QLog.w("NearbyProfileSendMsgDialog", 1, ((StringBuilder)localObject1).toString());
    NearbyProfileSendMsgDialog.Companion.a(a, (Function1)NearbyProfileSendMsgDialog.goToSendMsg.1.INSTANCE);
    localObject1 = (NearbyProfileDisplayPanel)i.get();
    if (localObject1 != null)
    {
      Object localObject2 = ((NearbyProfileDisplayPanel)localObject1).e;
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "mActivity");
      NearbyProfileReportKt.a((NearbyPeopleProfileActivity)localObject2, paramString);
      localObject2 = ((NearbyProfileDisplayPanel)localObject1).f;
      if (localObject2 != null)
      {
        ((NearbyPeopleCard)localObject2).firstOfficialMsg = paramString;
        ((NearbyProfileDisplayPanel)localObject1).p();
        dismissAllowingStateLoss();
      }
    }
  }
  
  private final void c()
  {
    if (this.h)
    {
      QLog.w("NearbyProfileSendMsgDialog", 1, "loadContent: loading, return");
      QQToast.makeText(getContext(), 1946615827, 0).show();
      return;
    }
    QLog.w("NearbyProfileSendMsgDialog", 1, "loadContent");
    this.h = true;
    Object localObject = (NearbyProfileDisplayPanel)i.get();
    if (localObject != null)
    {
      localObject = ((NearbyProfileDisplayPanel)localObject).e;
      if (localObject != null)
      {
        localObject = ((NearbyPeopleProfileActivity)localObject).getAppRuntime();
        break label76;
      }
    }
    localObject = null;
    label76:
    ProtoUtils.a((AppRuntime)localObject, (ProtoUtils.TroopProtocolObserver)new NearbyProfileSendMsgDialog.loadContent.1(this), new nearbyProfile.GetGreetReq().toByteArray(), "trpc.nearby.trpc_nearby_profile.trpc_nearby_profile.GetGreet");
  }
  
  private final void d()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null)
    {
      Intrinsics.checkExpressionValueIsNotNull(localFragmentActivity, "activity ?: return");
      DialogUtil.a((Context)localFragmentActivity, 230, localFragmentActivity.getString(1946615834), (CharSequence)localFragmentActivity.getString(1946615831), localFragmentActivity.getString(1946615836), localFragmentActivity.getString(1946615832), (DialogInterface.OnClickListener)NearbyProfileSendMsgDialog.showCantSendMsgDialog.tipDialog.1.a, (DialogInterface.OnClickListener)new NearbyProfileSendMsgDialog.showCantSendMsgDialog.tipDialog.2(this)).show();
    }
  }
  
  private final void e()
  {
    if (this.e <= 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cant send msg, show dialog, leftSendMsgCount=");
      ((StringBuilder)localObject).append(this.e);
      QLog.w("NearbyProfileSendMsgDialog", 1, ((StringBuilder)localObject).toString());
      d();
      dismissAllowingStateLoss();
    }
    Object localObject = this.c;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("sendMsgLayout");
    }
    ((ViewGroup)localObject).removeAllViews();
    LayoutInflater localLayoutInflater = LayoutInflater.from(((ViewGroup)localObject).getContext());
    Iterator localIterator = ((Iterable)this.f).iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      View localView1 = localLayoutInflater.inflate(1946484748, (ViewGroup)localObject, false);
      ((TextView)localView1.findViewById(1946419234)).setText((CharSequence)str);
      View localView2 = localView1.findViewById(1946419240);
      localView2.setTag(str);
      localView2.setOnClickListener((View.OnClickListener)this);
      ((ViewGroup)localObject).addView(localView1);
    }
    localObject = this.d;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("leftSendMsgContentTv");
    }
    ((TextView)localObject).setText((CharSequence)((TextView)localObject).getContext().getString(1946615826, new Object[] { Integer.valueOf(this.e) }));
  }
  
  public void b()
  {
    HashMap localHashMap = this.j;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  public void onClick(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "v");
    switch (paramView.getId())
    {
    default: 
      paramView = paramView.getTag();
      if (!(paramView instanceof String))
      {
        QLog.w("NearbyProfileSendMsgDialog", 1, "wrong click");
        return;
      }
    case 1946419238: 
      NearbyProfileSendMsgDialog.Companion.a(a);
      dismissAllowingStateLoss();
      return;
    case 1946419237: 
      c();
      return;
    case 1946419226: 
      dismissAllowingStateLoss();
      return;
      a((String)paramView);
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    Object localObject = (NearbyProfileDisplayPanel)i.get();
    if (localObject != null)
    {
      localObject = ((NearbyProfileDisplayPanel)localObject).e;
      if (localObject != null) {
        NearbyProfileReportKt.e((NearbyPeopleProfileActivity)localObject);
      }
    }
    c();
    super.onCreate(paramBundle);
    setStyle(0, 16974122);
    this.b = System.currentTimeMillis();
  }
  
  @NotNull
  public Dialog onCreateDialog(@Nullable Bundle paramBundle)
  {
    paramBundle = super.onCreateDialog(paramBundle);
    Window localWindow = paramBundle.getWindow();
    if (localWindow != null) {
      localWindow.setBackgroundDrawable((Drawable)new ColorDrawable(0));
    }
    Intrinsics.checkExpressionValueIsNotNull(paramBundle, "super.onCreateDialog(sav…)\n            }\n        }");
    return paramBundle;
  }
  
  @NotNull
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = LayoutInflater.from(paramLayoutInflater.getContext()).inflate(1946484736, paramViewGroup, false);
    paramViewGroup = paramLayoutInflater.findViewById(1946419226);
    paramBundle = (View.OnClickListener)this;
    paramViewGroup.setOnClickListener(paramBundle);
    paramLayoutInflater.findViewById(1946419227).setOnClickListener(paramBundle);
    paramLayoutInflater.findViewById(1946419238).setOnClickListener(paramBundle);
    paramLayoutInflater.findViewById(1946419237).setOnClickListener(paramBundle);
    paramViewGroup = paramLayoutInflater.findViewById(1946419228);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "findViewById(R.id.send_msg_layout)");
    this.c = ((ViewGroup)paramViewGroup);
    paramViewGroup = paramLayoutInflater.findViewById(1946419235);
    Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "findViewById(R.id.tv_left_send_msg_count)");
    this.d = ((TextView)paramViewGroup);
    int k = this.g;
    if (k != 0)
    {
      if (k == 2)
      {
        this.g = 3;
        e();
      }
    }
    else {
      this.g = 1;
    }
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "LayoutInflater.from(infl…}\n            }\n        }");
    return paramLayoutInflater;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileSendMsgDialog
 * JD-Core Version:    0.7.0.1
 */