package com.tencent.share;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.colornote.api.IColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/share/CommonShareHelper;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "Landroid/content/DialogInterface$OnDismissListener;", "Lcom/tencent/mobileqq/colornote/IServiceInfo;", "act", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getAct", "()Landroid/content/Context;", "colorNoteController", "Lcom/tencent/mobileqq/colornote/api/IColorNoteController;", "extraParams", "Landroid/os/Bundle;", "getExtraParams", "()Landroid/os/Bundle;", "setExtraParams", "(Landroid/os/Bundle;)V", "shareDialogBuilder", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;", "shareFrom", "", "getShareFrom", "()Ljava/lang/String;", "setShareFrom", "(Ljava/lang/String;)V", "shareSheetItemsRule", "", "webShare", "Lcom/tencent/share/WebShare;", "getWebShare", "()Lcom/tencent/share/WebShare;", "setWebShare", "(Lcom/tencent/share/WebShare;)V", "checkShareParams", "", "createActionSheetItems", "", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "()[Ljava/util/List;", "doActionAddColorNote", "doActionCopyLink", "doActionRemoveColorNote", "doActionReport", "doActionShareToQQFriend", "action", "", "toUinType", "toUin", "toNickName", "(ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "doActionShareToQQZone", "doActionShareToWeChat", "getColorNote", "Lcom/tencent/mobileqq/colornote/data/ColorNote;", "getIntentForStartForwardRecentActivity", "Landroid/content/Intent;", "initColorNote", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onItemClick", "item", "shareActionSheet", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "pluginStartActivityForResult", "plugin", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "intent", "requestCode", "", "setBizId", "bizId", "shouldAddAddColorNote", "", "shouldAddRemoveColorNote", "showActionSheet", "switchRequestCode", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class CommonShareHelper
  implements DialogInterface.OnDismissListener, IServiceInfo, ShareActionSheet.OnItemClickListener
{
  public static final CommonShareHelper.Companion a = new CommonShareHelper.Companion(null);
  @Nullable
  private WebShare b;
  private ShareActionSheetBuilder c;
  private long d;
  private IColorNoteController e;
  @NotNull
  private Bundle f;
  @NotNull
  private String g;
  @NotNull
  private final Context h;
  
  public CommonShareHelper(@NotNull Context paramContext)
  {
    this.h = paramContext;
    j();
    this.d = 4L;
    this.f = new Bundle();
    this.g = "general_url";
  }
  
  private final void h()
  {
    Object localObject = this.h;
    if ((localObject instanceof Activity))
    {
      localObject = ((Activity)localObject).getIntent().getStringExtra("big_brother_source_key");
      if (localObject != null)
      {
        int i;
        if (((CharSequence)localObject).length() == 0) {
          i = 1;
        } else {
          i = 0;
        }
        if (i == 0) {}
      }
      else
      {
        a("biz_src_zz_bodong");
      }
    }
  }
  
  private final List<ShareActionSheetBuilder.ActionSheetItem>[] i()
  {
    List localList = (List)new ArrayList();
    Object localObject1 = (AppRuntime)null;
    Object localObject2 = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "BaseApplicationImpl.getApplication()");
    if (((BaseApplicationImpl)localObject2).getRuntime() != null)
    {
      localObject1 = BaseApplicationImpl.getApplication();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.getApplication()");
      localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)((AppRuntime)localObject1).getAccount())) && ((this.d & 0x8) == 0L))
    {
      localObject2 = ShareActionSheetBuilder.ActionSheetItem.build(2);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "ShareActionSheetBuilder.…em.ACTION_SEND_TO_FRIEND)");
      localList.add(localObject2);
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)((AppRuntime)localObject1).getAccount())) && ((this.d & 0x10) == 0L))
    {
      localObject2 = ShareActionSheetBuilder.ActionSheetItem.build(3);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "ShareActionSheetBuilder.…tem.ACTION_SEND_TO_QZONE)");
      localList.add(localObject2);
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)((AppRuntime)localObject1).getAccount())) && ((this.d & 0x4000) == 0L))
    {
      localObject2 = ShareActionSheetBuilder.ActionSheetItem.build(9);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "ShareActionSheetBuilder.…em.ACTION_SEND_TO_WECHAT)");
      localList.add(localObject2);
    }
    if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)((AppRuntime)localObject1).getAccount())) && ((this.d & 0x8000) == 0L))
    {
      localObject1 = ShareActionSheetBuilder.ActionSheetItem.build(10);
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "ShareActionSheetBuilder.…ON_SEND_TO_WECHAT_CIRCLE)");
      localList.add(localObject1);
    }
    localObject1 = (List)new ArrayList();
    if (f()) {
      Intrinsics.checkExpressionValueIsNotNull(ShareActionSheetBuilder.ActionSheetItem.build(70), "ShareActionSheetBuilder.…em.ACTION_ADD_COLOR_NOTE)");
    }
    if (g()) {
      Intrinsics.checkExpressionValueIsNotNull(ShareActionSheetBuilder.ActionSheetItem.build(82), "ShareActionSheetBuilder.…ACTION_REMOVE_COLOR_NOTE)");
    }
    if ((this.d & 0x20) == 0L) {
      Intrinsics.checkExpressionValueIsNotNull(ShareActionSheetBuilder.ActionSheetItem.build(1), "ShareActionSheetBuilder.…heetItem.ACTION_COPYLINK)");
    }
    Intrinsics.checkExpressionValueIsNotNull(ShareActionSheetBuilder.ActionSheetItem.build(11), "ShareActionSheetBuilder.…nSheetItem.ACTION_REPORT)");
    return new List[] { localList, localObject1 };
  }
  
  private final void j()
  {
    IColorNoteController localIColorNoteController = (IColorNoteController)QRoute.api(IColorNoteController.class);
    localIColorNoteController.init(this.h, false, true);
    localIColorNoteController.setServiceInfo((IServiceInfo)this);
    Context localContext = this.h;
    Object localObject = localContext;
    if (!(localContext instanceof Activity)) {
      localObject = null;
    }
    localObject = (Activity)localObject;
    if (localObject != null) {
      localIColorNoteController.attachToActivity((Activity)localObject);
    }
    this.e = localIColorNoteController;
  }
  
  private final Intent k()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_type", 1001);
    localIntent.putExtra("pluginName", "web_share");
    return localIntent;
  }
  
  @Nullable
  public final WebShare a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    WebShare localWebShare = this.b;
    if (localWebShare != null) {
      localWebShare.a(paramInt);
    }
  }
  
  public void a(int paramInt, @Nullable Integer paramInteger, @Nullable String paramString1, @Nullable String paramString2)
  {
    WebShare localWebShare = this.b;
    if (localWebShare != null)
    {
      int i;
      if (paramInteger != null) {
        i = paramInteger.intValue();
      } else {
        i = 0;
      }
      if (paramString1 == null) {
        paramString1 = "";
      }
      if (paramString2 == null) {
        paramString2 = "";
      }
      localWebShare.a(paramInt, i, paramString1, paramString2);
    }
  }
  
  public final void a(@Nullable WebShare paramWebShare)
  {
    this.b = paramWebShare;
  }
  
  public void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "bizId");
    Context localContext = this.h;
    Object localObject = localContext;
    if (!(localContext instanceof Activity)) {
      localObject = null;
    }
    localObject = (Activity)localObject;
    if (localObject != null)
    {
      localObject = ((Activity)localObject).getIntent();
      if (localObject != null) {
        ((Intent)localObject).putExtra("big_brother_source_key", paramString);
      }
    }
  }
  
  @NotNull
  public final Bundle b()
  {
    return this.f;
  }
  
  @NotNull
  public final String c()
  {
    return this.g;
  }
  
  public final void d()
  {
    if (this.c == null) {
      this.c = new ShareActionSheetBuilder(this.h, false, 2);
    }
    ShareActionSheetBuilder localShareActionSheetBuilder = this.c;
    if (localShareActionSheetBuilder != null) {
      localShareActionSheetBuilder.setIntentForStartForwardRecentActivity(k());
    }
    localShareActionSheetBuilder = this.c;
    if (localShareActionSheetBuilder != null) {
      localShareActionSheetBuilder.setActionSheetItems(i());
    }
    localShareActionSheetBuilder = this.c;
    if (localShareActionSheetBuilder != null) {
      localShareActionSheetBuilder.setItemClickListenerV2((ShareActionSheet.OnItemClickListener)this);
    }
    localShareActionSheetBuilder = this.c;
    if (localShareActionSheetBuilder != null) {
      localShareActionSheetBuilder.setOnDismissListener((DialogInterface.OnDismissListener)this);
    }
    localShareActionSheetBuilder = this.c;
    if (localShareActionSheetBuilder != null) {
      localShareActionSheetBuilder.setRowVisibility(0, 0, 0);
    }
    h();
    try
    {
      localShareActionSheetBuilder = this.c;
      if (localShareActionSheetBuilder != null)
      {
        localShareActionSheetBuilder.show();
        return;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("actionSheet.show exception=");
        localStringBuilder.append(localException);
        QLog.d("CommonShareHelper", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void e()
  {
    WebShare localWebShare = this.b;
    if (localWebShare != null) {
      localWebShare.b();
    }
  }
  
  public final boolean f()
  {
    IColorNoteController localIColorNoteController = this.e;
    return (localIColorNoteController != null) && (localIColorNoteController.shouldDisplayColorNote()) && (localIColorNoteController.canAddColorNote()) && (!localIColorNoteController.isColorNoteExist());
  }
  
  public final boolean g()
  {
    IColorNoteController localIColorNoteController = this.e;
    return (localIColorNoteController != null) && (localIColorNoteController.shouldDisplayColorNote()) && (localIColorNoteController.isColorNoteExist());
  }
  
  @NotNull
  public ColorNote getColorNote()
  {
    Object localObject2 = new JSONObject();
    Object localObject1 = new ColorNote.Builder().a(16908288).a("subType").b("title").c("subTitle").d("coverUrl");
    localObject2 = ((JSONObject)localObject2).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "json.toString()");
    Charset localCharset = Charsets.UTF_8;
    if (localObject2 != null)
    {
      localObject2 = ((String)localObject2).getBytes(localCharset);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.String).getBytes(charset)");
      localObject1 = ((ColorNote.Builder)localObject1).a((byte[])localObject2).a();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "ColorNote.Builder().setS…).toByteArray()).create()");
      return localObject1;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  public void onDismiss(@Nullable DialogInterface paramDialogInterface) {}
  
  public void onItemClick(@Nullable ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, @Nullable ShareActionSheet paramShareActionSheet)
  {
    if (paramActionSheetItem == null) {
      return;
    }
    paramShareActionSheet = this.c;
    if (paramShareActionSheet != null) {
      paramShareActionSheet.dismiss();
    }
    if (paramActionSheetItem.action == 72)
    {
      this.f.putString("to_qq", paramActionSheetItem.uin);
      this.f.putString("to_uin_name", paramActionSheetItem.label);
      this.f.putInt("to_uin_type", paramActionSheetItem.uinType);
    }
    int i = paramActionSheetItem.action;
    if (i != 2) {
      if (i != 3)
      {
        if ((i != 9) && (i != 10))
        {
          if ((i == 72) || (i == 73)) {}
        }
        else {
          a(paramActionSheetItem.action);
        }
      }
      else
      {
        e();
        return;
      }
    }
    a(paramActionSheetItem.action, Integer.valueOf(paramActionSheetItem.uinType), paramActionSheetItem.uin, paramActionSheetItem.label);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.share.CommonShareHelper
 * JD-Core Version:    0.7.0.1
 */