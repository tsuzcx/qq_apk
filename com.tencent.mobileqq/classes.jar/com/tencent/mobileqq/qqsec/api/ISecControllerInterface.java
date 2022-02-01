package com.tencent.mobileqq.qqsec.api;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import java.util.ArrayList;
import org.json.JSONObject;

public abstract interface ISecControllerInterface
{
  public abstract ArrayList<String> a(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract void a(Activity paramActivity, String paramString);
  
  public abstract void a(Activity paramActivity, JSONObject paramJSONObject);
  
  public abstract void a(Context paramContext, String paramString);
  
  public abstract void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void a(BaseQQAppInterface paramBaseQQAppInterface);
  
  public abstract void a(BaseQQAppInterface paramBaseQQAppInterface, ProgressDialog paramProgressDialog);
  
  public abstract void a(QBaseActivity paramQBaseActivity);
  
  public abstract void a(QBaseActivity paramQBaseActivity, boolean paramBoolean, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqsec.api.ISecControllerInterface
 * JD-Core Version:    0.7.0.1
 */