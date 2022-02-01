package com.tencent.mobileqq.tianshu.data;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import java.util.ArrayList;

public abstract interface IQbossCallback
{
  public abstract void a(int paramInt, String paramString1, String paramString2, ArrayList<Integer> paramArrayList);
  
  public abstract void a(Bundle paramBundle, String paramString, AppInterface paramAppInterface);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.tianshu.data.IQbossCallback
 * JD-Core Version:    0.7.0.1
 */