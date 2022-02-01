package com.tencent.mobileqq.guild.api;

import android.text.Editable;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IGuildTextUtil
  extends QRouteApi
{
  public abstract CharSequence filterTailSpace(Editable paramEditable);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.api.IGuildTextUtil
 * JD-Core Version:    0.7.0.1
 */