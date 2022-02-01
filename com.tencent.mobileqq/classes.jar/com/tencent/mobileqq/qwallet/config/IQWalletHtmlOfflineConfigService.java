package com.tencent.mobileqq.qwallet.config;

import android.widget.TextView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQWalletHtmlOfflineConfigService
  extends QRouteApi
{
  public abstract void setShengpiziTypeface(TextView paramTextView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.config.IQWalletHtmlOfflineConfigService
 * JD-Core Version:    0.7.0.1
 */