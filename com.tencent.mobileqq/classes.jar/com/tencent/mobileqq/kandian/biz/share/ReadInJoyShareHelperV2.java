package com.tencent.mobileqq.kandian.biz.share;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.OpenWithQQBrowser;
import com.tencent.mobileqq.kandian.base.utils.OpenWithQQBrowser.UiCallback;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.base.view.api.IFontSizePanel;
import com.tencent.mobileqq.kandian.base.view.widget.FontSizePanel;
import com.tencent.mobileqq.kandian.base.view.widget.FontSizePanel.Builder;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.fastweb.util.ScreenShotImageUtil;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoReporter;
import com.tencent.mobileqq.kandian.biz.share.api.ShareCallBack;
import com.tencent.mobileqq.kandian.glue.router.RIJJumpUtils;
import com.tencent.mobileqq.kandian.repo.share.ShareReport;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheet.OnItemClickListener;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.util.WeakReferenceHandler;
import com.tencent.widget.RangeButtonView.OnChangeListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2;", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet$OnItemClickListener;", "Landroid/os/Handler$Callback;", "activity", "Landroid/app/Activity;", "app", "Lcom/tencent/common/app/AppInterface;", "processor", "Lcom/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2$BaseSheetItemClickProcessor;", "(Landroid/app/Activity;Lcom/tencent/common/app/AppInterface;Lcom/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2$BaseSheetItemClickProcessor;)V", "getActivity", "()Landroid/app/Activity;", "curFontSizeIndex", "", "fontSizeChangeListener", "Lcom/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2$OnFontSizeChangeListener;", "fontSizePanel", "Lcom/tencent/mobileqq/kandian/base/view/api/IFontSizePanel;", "from", "isShowing", "", "()Z", "openWithQQBrowser", "Lcom/tencent/mobileqq/kandian/base/utils/OpenWithQQBrowser;", "getProcessor", "()Lcom/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2$BaseSheetItemClickProcessor;", "setProcessor", "(Lcom/tencent/mobileqq/kandian/biz/share/ReadInJoyShareHelperV2$BaseSheetItemClickProcessor;)V", "rangeBtnListener", "Lcom/tencent/widget/RangeButtonView$OnChangeListener;", "shareActionSheet", "Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "getShareActionSheet", "()Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "setShareActionSheet", "(Lcom/tencent/mobileqq/widget/share/ShareActionSheet;)V", "shareToComputerHelper", "Lcom/tencent/mobileqq/kandian/biz/share/ShareToComputerHelper;", "uiHandler", "Lcom/tencent/util/WeakReferenceHandler;", "closeFontSizePanel", "copyLink", "", "url", "", "dismiss", "doScreenshot", "findActionName", "action", "findItemByAction", "Lcom/tencent/mobileqq/kandian/biz/share/ActionItem;", "line1", "", "line2", "getActionSheetItems", "", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", "itemsLines", "([Ljava/util/List;)[Ljava/util/List;", "handleMessage", "msg", "Landroid/os/Message;", "onDestroy", "onItemClick", "item", "openPhotoPlusActivity", "path", "openWithSysBrowser", "sendComputer", "showActionSheet", "itemsLine2", "articleId", "([Ljava/util/List;ILjava/lang/String;)Lcom/tencent/mobileqq/widget/share/ShareActionSheet;", "showFontSizePanel", "listener", "isTxtRatio", "BaseSheetItemClickProcessor", "Companion", "OnFontSizeChangeListener", "ShareUnitForOld", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ReadInJoyShareHelperV2
  implements Handler.Callback, ShareActionSheet.OnItemClickListener
{
  public static final ReadInJoyShareHelperV2.Companion a = new ReadInJoyShareHelperV2.Companion(null);
  private static final Map<String, Integer> m = MapsKt.mapOf(new Pair[] { TuplesKt.to("kandian", Integer.valueOf(13)), TuplesKt.to("qq_friend", Integer.valueOf(2)), TuplesKt.to("qzone", Integer.valueOf(3)), TuplesKt.to("we_chat", Integer.valueOf(9)), TuplesKt.to("we_chat_circle", Integer.valueOf(10)), TuplesKt.to("we_bo", Integer.valueOf(12)), TuplesKt.to("qq_browser", Integer.valueOf(5)), TuplesKt.to("sys_browser", Integer.valueOf(4)), TuplesKt.to("screen_shot", Integer.valueOf(21)), TuplesKt.to("set_font", Integer.valueOf(7)), TuplesKt.to("add_favourite", Integer.valueOf(6)), TuplesKt.to("cancel_favorite", Integer.valueOf(84)), TuplesKt.to("send_pc", Integer.valueOf(26)), TuplesKt.to("copy_link", Integer.valueOf(1)), TuplesKt.to("report", Integer.valueOf(11)), TuplesKt.to("dis_like", Integer.valueOf(44)), TuplesKt.to("not_care", Integer.valueOf(38)), TuplesKt.to("add_friend", Integer.valueOf(35)), TuplesKt.to("open_aio", Integer.valueOf(37)), TuplesKt.to("open_more_info", Integer.valueOf(31)), TuplesKt.to("remove_fans", Integer.valueOf(137)), TuplesKt.to("personal_c2c", Integer.valueOf(138)), TuplesKt.to("unfollow", Integer.valueOf(32)), TuplesKt.to("save_picture", Integer.valueOf(39)), TuplesKt.to("play_feedback", Integer.valueOf(161)), TuplesKt.to("add_floating_ball", Integer.valueOf(70)), TuplesKt.to("cancel_floating_ball", Integer.valueOf(82)), TuplesKt.to("open_barrage", Integer.valueOf(163)), TuplesKt.to("close_barrage", Integer.valueOf(164)), TuplesKt.to("rij_play_setup", Integer.valueOf(165)) });
  private static final List<ShareCallBack> n = (List)new ArrayList();
  @NotNull
  private ShareActionSheet b;
  private final ShareToComputerHelper c;
  private OpenWithQQBrowser d;
  private IFontSizePanel e;
  private final WeakReferenceHandler f;
  private int g;
  private ReadInJoyShareHelperV2.OnFontSizeChangeListener h;
  private int i;
  private final RangeButtonView.OnChangeListener j;
  @NotNull
  private final Activity k;
  @Nullable
  private ReadInJoyShareHelperV2.BaseSheetItemClickProcessor l;
  
  public ReadInJoyShareHelperV2(@NotNull Activity paramActivity, @NotNull AppInterface paramAppInterface, @Nullable ReadInJoyShareHelperV2.BaseSheetItemClickProcessor paramBaseSheetItemClickProcessor)
  {
    this.k = paramActivity;
    this.l = paramBaseSheetItemClickProcessor;
    this.g = -1;
    this.j = ((RangeButtonView.OnChangeListener)new ReadInJoyShareHelperV2.rangeBtnListener.1(this));
    paramActivity = new ShareActionSheetV2.Param();
    paramActivity.context = ((Context)this.k);
    paramActivity = ShareActionSheetFactory.create(paramActivity);
    Intrinsics.checkExpressionValueIsNotNull(paramActivity, "ShareActionSheetFactory.create(param)");
    this.b = paramActivity;
    this.k.getIntent().putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    this.c = new ShareToComputerHelper(paramAppInterface);
    this.f = new WeakReferenceHandler((Handler.Callback)this);
  }
  
  @JvmStatic
  @NotNull
  public static final List<ActionItem> a(@NotNull JSONArray paramJSONArray, @Nullable JSONObject paramJSONObject)
  {
    return a.a(paramJSONArray, paramJSONObject);
  }
  
  @JvmStatic
  public static final void a(int paramInt, boolean paramBoolean, @Nullable String paramString)
  {
    a.a(paramInt, paramBoolean, paramString);
  }
  
  private final void e(String paramString)
  {
    if (TextUtils.isEmpty((CharSequence)paramString))
    {
      QRUtils.a(1, 2131892978);
      return;
    }
    paramString = ((IAELaunchEditPic)QRoute.api(IAELaunchEditPic.class)).startEditPic(this.k, paramString, true, true, true, true, true, 4);
    this.k.startActivity(paramString);
  }
  
  @JvmStatic
  @NotNull
  public static final List<Integer> i()
  {
    return a.a();
  }
  
  @JvmStatic
  @NotNull
  public static final List<ActionItem> j()
  {
    return a.b();
  }
  
  @JvmStatic
  @NotNull
  public static final List<ActionItem> k()
  {
    return a.c();
  }
  
  @Nullable
  public final ActionItem a(@NotNull List<? extends ActionItem> paramList1, @NotNull List<? extends ActionItem> paramList2, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramList1, "line1");
    Intrinsics.checkParameterIsNotNull(paramList2, "line2");
    Object localObject = paramList1.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActionItem localActionItem = (ActionItem)((Iterator)localObject).next();
      if (localActionItem.b == paramInt) {
        return localActionItem;
      }
    }
    paramList2 = paramList2.iterator();
    while (paramList2.hasNext())
    {
      localObject = (ActionItem)paramList2.next();
      if (((ActionItem)localObject).b == paramInt) {
        return localObject;
      }
    }
    if ((paramInt == 72) || (paramInt == 73))
    {
      paramList1 = paramList1.iterator();
      while (paramList1.hasNext())
      {
        paramList2 = (ActionItem)paramList1.next();
        if (paramList2.b == 2) {
          return paramList2;
        }
      }
    }
    return null;
  }
  
  @NotNull
  public final ShareActionSheet a()
  {
    return this.b;
  }
  
  @Nullable
  public final ShareActionSheet a(@NotNull List<Integer>[] paramArrayOfList, int paramInt, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfList, "itemsLine2");
    Intrinsics.checkParameterIsNotNull(paramString, "articleId");
    ReadInJoyUtils.a();
    this.i = paramInt;
    this.k.getIntent().putExtra("big_brother_source_key", "biz_src_feeds_kandian");
    this.b.setActionSheetItems(a(paramArrayOfList));
    this.b.setItemClickListenerV2((ShareActionSheet.OnItemClickListener)this);
    paramArrayOfList = this.b;
    Intent localIntent = new Intent();
    localIntent.putExtra("forward_type", 44);
    paramArrayOfList.setIntentForStartForwardRecentActivity(localIntent);
    this.b.setRowVisibility(0, 0, 0);
    this.b.show();
    ShareReport.a.a(paramInt, paramString, VideoReporter.c());
    return this.b;
  }
  
  @NotNull
  public final String a(int paramInt)
  {
    boolean bool = m.containsValue(Integer.valueOf(paramInt));
    Object localObject1 = "other";
    Object localObject2 = localObject1;
    if (bool)
    {
      Iterator localIterator = m.keySet().iterator();
      for (;;)
      {
        localObject2 = localObject1;
        if (!localIterator.hasNext()) {
          break label110;
        }
        localObject2 = (String)localIterator.next();
        Object localObject3 = m.get(localObject2);
        if (localObject3 == null) {
          break;
        }
        if (paramInt == ((Integer)localObject3).intValue()) {
          localObject1 = localObject2;
        }
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.Int");
    }
    label110:
    return localObject2;
  }
  
  public final void a(@NotNull ReadInJoyShareHelperV2.OnFontSizeChangeListener paramOnFontSizeChangeListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnFontSizeChangeListener, "listener");
    a(paramOnFontSizeChangeListener, false);
  }
  
  public final void a(@NotNull ReadInJoyShareHelperV2.OnFontSizeChangeListener paramOnFontSizeChangeListener, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramOnFontSizeChangeListener, "listener");
    this.h = paramOnFontSizeChangeListener;
    if (this.g == -1)
    {
      paramOnFontSizeChangeListener = new StringBuilder();
      paramOnFontSizeChangeListener.append("readinjoy_font_size_index_sp");
      paramOnFontSizeChangeListener.append(RIJQQAppInterfaceUtil.d());
      paramOnFontSizeChangeListener = RIJSPUtils.b(paramOnFontSizeChangeListener.toString(), Integer.valueOf(2));
      Intrinsics.checkExpressionValueIsNotNull(paramOnFontSizeChangeListener, "RIJSPUtils.getReadInJoyS…faceUtil.getAccount(), 2)");
      this.g = ((Number)paramOnFontSizeChangeListener).intValue();
    }
    paramOnFontSizeChangeListener = new FontSizePanel.Builder(this.k.getLayoutInflater()).b(this.j).b(this.g).a(paramBoolean).b();
    Window localWindow = this.k.getWindow();
    Intrinsics.checkExpressionValueIsNotNull(localWindow, "activity.window");
    this.e = ((IFontSizePanel)paramOnFontSizeChangeListener.b(localWindow.getDecorView()));
  }
  
  public final void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    if (this.d == null) {
      this.d = new OpenWithQQBrowser(this.k, (OpenWithQQBrowser.UiCallback)new ReadInJoyShareHelperV2.openWithQQBrowser.1());
    }
    OpenWithQQBrowser localOpenWithQQBrowser = this.d;
    if (localOpenWithQQBrowser != null) {
      localOpenWithQQBrowser.a(paramString);
    }
  }
  
  @NotNull
  public final List<ShareActionSheetBuilder.ActionSheetItem>[] a(@NotNull List<Integer>[] paramArrayOfList)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfList, "itemsLines");
    ArrayList localArrayList1 = new ArrayList();
    int i2 = paramArrayOfList.length;
    int i1 = 0;
    while (i1 < i2)
    {
      Object localObject = paramArrayOfList[i1];
      ArrayList localArrayList2 = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        localArrayList2.add(ShareActionSheetBuilder.ActionSheetItem.build(((Number)((Iterator)localObject).next()).intValue()));
      }
      localArrayList1.add(localArrayList2);
      i1 += 1;
    }
    paramArrayOfList = ((Collection)localArrayList1).toArray(new List[0]);
    if (paramArrayOfList != null) {
      return (List[])paramArrayOfList;
    }
    paramArrayOfList = new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    for (;;)
    {
      throw paramArrayOfList;
    }
  }
  
  public final void b()
  {
    if (this.b.isShowing()) {
      this.b.dismiss();
    }
  }
  
  public final void b(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    paramString = new Intent("android.intent.action.VIEW", Uri.parse(paramString));
    paramString.putExtra("normal", true);
    paramString.putExtra("big_brother_source_key", RIJJumpUtils.a(0));
    try
    {
      this.k.startActivity(paramString);
      return;
    }
    catch (ActivityNotFoundException paramString)
    {
      label52:
      break label52;
    }
    QRUtils.a(1, 2131892956);
  }
  
  public final void c()
  {
    Object localObject = this.c;
    if (localObject != null) {
      ((ShareToComputerHelper)localObject).a();
    }
    localObject = this.e;
    if (localObject != null) {
      ((IFontSizePanel)localObject).a();
    }
    this.f.removeCallbacksAndMessages(null);
    b();
  }
  
  public final void c(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Object localObject = this.k.getSystemService("clipboard");
    if (localObject != null)
    {
      ((ClipboardManager)localObject).setText((CharSequence)paramString);
      QRUtils.a(2, 2131888247);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.text.ClipboardManager");
  }
  
  public final void d(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Object localObject = this.c;
    if (localObject != null) {
      paramString = Long.valueOf(((ShareToComputerHelper)localObject).a(paramString));
    } else {
      paramString = null;
    }
    localObject = ShareReport.a;
    boolean bool;
    if ((paramString == null) || (paramString.longValue() != 0L)) {
      bool = true;
    } else {
      bool = false;
    }
    ((ShareReport)localObject).a(bool);
  }
  
  public final boolean d()
  {
    IFontSizePanel localIFontSizePanel = this.e;
    if ((localIFontSizePanel != null) && (localIFontSizePanel.b()))
    {
      localIFontSizePanel.c();
      return true;
    }
    return false;
  }
  
  public final void e()
  {
    Object localObject = this.k.getWindow();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "activity.window");
    localObject = ((Window)localObject).getDecorView();
    ((View)localObject).buildDrawingCache();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "root");
    Bitmap localBitmap1 = ((View)localObject).getDrawingCache();
    if (localBitmap1 != null)
    {
      Bitmap localBitmap2 = ScreenShotImageUtil.a(this.k.getWindow(), localBitmap1);
      if (localBitmap2 != null)
      {
        QQToast localQQToast = QQToast.makeText((Context)BaseApplicationImpl.getContext(), 0, 2131892975, 0);
        BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
        Intrinsics.checkExpressionValueIsNotNull(localBaseApplication, "BaseApplicationImpl.getContext()");
        localQQToast.show(localBaseApplication.getResources().getDimensionPixelSize(2131299920));
        ThreadManager.executeOnFileThread((Runnable)new ReadInJoyShareHelperV2.doScreenshot.1(this, localBitmap2));
      }
      localBitmap1.recycle();
    }
    ((View)localObject).destroyDrawingCache();
  }
  
  @NotNull
  public final Activity f()
  {
    return this.k;
  }
  
  public boolean handleMessage(@NotNull Message paramMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramMessage, "msg");
    if ((paramMessage.what == 101) && (paramMessage.obj != null))
    {
      paramMessage = paramMessage.obj;
      if (paramMessage != null) {
        e((String)paramMessage);
      } else {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
      }
    }
    return true;
  }
  
  public void onItemClick(@NotNull ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, @NotNull ShareActionSheet paramShareActionSheet)
  {
    Intrinsics.checkParameterIsNotNull(paramActionSheetItem, "item");
    Intrinsics.checkParameterIsNotNull(paramShareActionSheet, "shareActionSheet");
    this.b.dismiss();
    int i1 = paramActionSheetItem.action;
    if ((CollectionsKt.listOf(new Integer[] { Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(3), Integer.valueOf(72), Integer.valueOf(2), Integer.valueOf(73), Integer.valueOf(12) }).contains(Integer.valueOf(i1))) && (ShareReport.a.e())) {
      return;
    }
    paramShareActionSheet = this.l;
    if (paramShareActionSheet != null) {
      paramShareActionSheet.a(i1, paramActionSheetItem);
    }
    ShareReport.a.a(i1, VideoReporter.c(), a.a(i1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.ReadInJoyShareHelperV2
 * JD-Core Version:    0.7.0.1
 */