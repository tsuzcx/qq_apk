package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.IWordChainBiz;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tencent.im.qqwallet.GetRecommendWords.CopyWriter;

public class KeyWordChainBizImpl
  implements IWordChainBiz
{
  private List<String> a;
  
  public String a(List<GetRecommendWords.CopyWriter> paramList, boolean paramBoolean)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      GetRecommendWords.CopyWriter localCopyWriter = (GetRecommendWords.CopyWriter)paramList.remove(i);
      if (!TextUtils.isEmpty(localCopyWriter.info.get())) {
        return localCopyWriter.info.get();
      }
      i -= 1;
    }
    if (paramBoolean)
    {
      if (this.a == null)
      {
        this.a = new ArrayList(7);
        this.a.add("花");
        this.a.add("风");
        this.a.add("夜");
        this.a.add("雨");
        this.a.add("情");
        this.a.add("云");
        this.a.add("春");
      }
      i = new Random().nextInt(this.a.size());
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("getRandomIdiom get backIdiom:");
        paramList.append(i);
        paramList.append(" backWordListSize:");
        paramList.append(this.a.size());
        QLog.i("KeyWordChainBizImpl", 2, paramList.toString());
      }
      return (String)this.a.get(i);
    }
    return "";
  }
  
  public boolean a(String paramString)
  {
    return !TextUtils.isEmpty(paramString);
  }
  
  public InputFilter[] a(int paramInt)
  {
    int i;
    if ((!SystemUtil.g()) && (!SystemUtil.h())) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (paramInt > 0)) {
      return new InputFilter[] { new InputFilter.LengthFilter(paramInt) };
    }
    return new InputFilter[0];
  }
  
  public void b(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.KeyWordChainBizImpl
 * JD-Core Version:    0.7.0.1
 */