package com.tencent.mobileqq.kandian.biz.share.api;

import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.widget.QQProgressDialog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/share/api/IScreenShotShareHelper;", "", "doOnPhotoPlusActivityEditResult", "", "photoPath", "", "originImagePath", "editType", "", "getLoadingDialog", "Lcom/tencent/mobileqq/widget/QQProgressDialog;", "getScreenshotFromType", "getScreenshotTitle", "getShareActionSheetTitle", "getUrl", "onConfigurationChanged", "onDestroy", "setActionSheetTitleArray", "actionSheetTitleArray", "Lorg/json/JSONArray;", "setItemClickListener", "itemClickListener", "Landroid/widget/AdapterView$OnItemClickListener;", "setScreenshotFromType", "screenshotFromType", "setScreenshotShareUrl", "screenshotShareUrl", "setScreenshotTitle", "screenshotTitle", "setSinaShareTitle", "title", "setUrl", "url", "shareScreenShotToQQ", "imgPath", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IScreenShotShareHelper
{
  public static final IScreenShotShareHelper.Companion a = IScreenShotShareHelper.Companion.a;
  
  @Nullable
  public abstract QQProgressDialog a();
  
  @Nullable
  public abstract String a();
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(@Nullable AdapterView.OnItemClickListener paramOnItemClickListener);
  
  public abstract void a(@Nullable String paramString);
  
  public abstract void a(@Nullable String paramString1, @Nullable String paramString2, int paramInt);
  
  public abstract void a(@Nullable JSONArray paramJSONArray);
  
  public abstract int b();
  
  @Nullable
  public abstract String b();
  
  public abstract void b(@Nullable String paramString);
  
  @Nullable
  public abstract String c();
  
  public abstract void c(@Nullable String paramString);
  
  public abstract void d(@Nullable String paramString);
  
  public abstract void e(@Nullable String paramString);
  
  public abstract void h();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.share.api.IScreenShotShareHelper
 * JD-Core Version:    0.7.0.1
 */