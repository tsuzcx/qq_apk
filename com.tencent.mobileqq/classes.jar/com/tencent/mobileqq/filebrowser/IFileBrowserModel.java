package com.tencent.mobileqq.filebrowser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.colornote.IServiceInfo;
import com.tencent.mobileqq.teamwork.bean.TeamWorkFileImportInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.util.ArrayList;
import org.json.JSONObject;

public abstract interface IFileBrowserModel
{
  public abstract float a();
  
  public abstract int a();
  
  public abstract Intent a();
  
  public abstract BaseAdapter a();
  
  public abstract IServiceInfo a();
  
  public abstract IFileBrowserData a();
  
  public abstract TeamWorkFileImportInfo a();
  
  public abstract String a();
  
  public abstract String a(Context paramContext);
  
  public abstract void a();
  
  public abstract void a(int paramInt);
  
  public abstract void a(Activity paramActivity);
  
  public abstract void a(Activity paramActivity, int paramInt, String paramString);
  
  public abstract void a(Activity paramActivity, String paramString);
  
  public abstract void a(Context paramContext);
  
  public abstract void a(Context paramContext, String paramString);
  
  public abstract void a(Bundle paramBundle);
  
  public abstract void a(IFileBrowserModel.OnEventListener paramOnEventListener);
  
  public abstract void a(IFileBrowserModel.OnMMApkSafeCheckListener paramOnMMApkSafeCheckListener);
  
  public abstract void a(IFileBrowserModel.OnThumbEventListener paramOnThumbEventListener);
  
  public abstract void a(IFileBrowserModel.OnTransEventListener paramOnTransEventListener);
  
  public abstract void a(IFileBrowserModel.OnZipEventListener paramOnZipEventListener);
  
  public abstract void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem);
  
  public abstract void a(JSONObject paramJSONObject, String paramString, Context paramContext);
  
  public abstract void a(JSONObject paramJSONObject, String paramString, TeamWorkFileImportInfo paramTeamWorkFileImportInfo, Activity paramActivity);
  
  public abstract boolean a();
  
  public abstract boolean a(Context paramContext, IFileBrowserModel.OnAppStorePromoteListener paramOnAppStorePromoteListener);
  
  public abstract ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] a();
  
  public abstract int b();
  
  public abstract String b();
  
  public abstract void b();
  
  public abstract boolean b();
  
  public abstract int c();
  
  public abstract String c();
  
  public abstract void c();
  
  public abstract boolean c();
  
  public abstract String d();
  
  public abstract void d();
  
  public abstract boolean d();
  
  public abstract String e();
  
  public abstract void e();
  
  public abstract boolean e();
  
  public abstract String f();
  
  public abstract void f();
  
  public abstract boolean f();
  
  public abstract String g();
  
  public abstract void g();
  
  public abstract void h();
  
  public abstract void i();
  
  public abstract void j();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.IFileBrowserModel
 * JD-Core Version:    0.7.0.1
 */