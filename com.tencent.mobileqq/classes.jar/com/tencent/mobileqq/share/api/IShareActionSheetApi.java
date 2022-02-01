package com.tencent.mobileqq.share.api;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.qroute.annotation.QRouteFactory;

@QAPI(process={"all"})
@QRouteFactory(singleton=false)
public abstract interface IShareActionSheetApi
  extends QRouteApi
{
  public abstract void dismiss();
  
  public abstract void init(Context paramContext);
  
  public abstract boolean isShowing();
  
  public abstract void setActionSheetClickListener(ShareActionSheetClickListener paramShareActionSheetClickListener);
  
  public abstract void setActionSheetItems(ShareConfig paramShareConfig);
  
  public abstract void setCancelListener(DialogInterface.OnCancelListener paramOnCancelListener);
  
  public abstract void setOnDismissListener(DialogInterface.OnDismissListener paramOnDismissListener);
  
  public abstract void setQCircleActionSheetClickListener(QCircleActionSheetClickListener paramQCircleActionSheetClickListener);
  
  public abstract void setRowVisibility(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract void show();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.share.api.IShareActionSheetApi
 * JD-Core Version:    0.7.0.1
 */