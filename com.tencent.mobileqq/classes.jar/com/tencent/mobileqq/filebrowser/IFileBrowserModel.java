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
  public abstract void A();
  
  public abstract void B();
  
  public abstract void C();
  
  public abstract IServiceInfo D();
  
  public abstract TeamWorkFileImportInfo E();
  
  public abstract boolean F();
  
  public abstract BaseAdapter G();
  
  public abstract IFileBrowserData a();
  
  public abstract String a(Context paramContext);
  
  public abstract void a(int paramInt);
  
  public abstract void a(Activity paramActivity);
  
  public abstract void a(Activity paramActivity, int paramInt, String paramString);
  
  public abstract void a(Activity paramActivity, String paramString);
  
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
  
  public abstract boolean a(Context paramContext, IFileBrowserModel.OnAppStorePromoteListener paramOnAppStorePromoteListener);
  
  public abstract void b();
  
  public abstract void b(Context paramContext);
  
  public abstract void c();
  
  public abstract void d();
  
  public abstract int e();
  
  public abstract String f();
  
  public abstract int g();
  
  public abstract String h();
  
  public abstract String i();
  
  public abstract boolean j();
  
  public abstract int k();
  
  public abstract float l();
  
  public abstract String m();
  
  public abstract boolean n();
  
  public abstract boolean o();
  
  public abstract boolean p();
  
  public abstract String q();
  
  public abstract String r();
  
  public abstract String s();
  
  public abstract boolean t();
  
  public abstract Intent u();
  
  public abstract ArrayList<ShareActionSheetBuilder.ActionSheetItem>[] v();
  
  public abstract void w();
  
  public abstract void x();
  
  public abstract void y();
  
  public abstract void z();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filebrowser.IFileBrowserModel
 * JD-Core Version:    0.7.0.1
 */