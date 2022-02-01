package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.IWordChainBiz;
import com.tencent.mobileqq.qwallet.hb.send.impl.WordChainHbFragment;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import tencent.im.qqwallet.GetRecommendWords.CopyWriter;

public class ContinueChainBizImpl
  implements IWordChainBiz
{
  List<String> a = new LinkedList();
  private List<String> b;
  private WordChainHbFragment c;
  private long d = 0L;
  
  public ContinueChainBizImpl(WordChainHbFragment paramWordChainHbFragment)
  {
    this.c = paramWordChainHbFragment;
  }
  
  private void b(int paramInt)
  {
    if (paramInt < this.c.k())
    {
      long l = NetConnInfoCenter.getServerTimeMillis();
      if (Math.abs(l - this.d) > 1000L)
      {
        this.d = l;
        this.c.c(String.format("该诗词可接龙最大次数是%d，请修改个数", new Object[] { Integer.valueOf(paramInt) }));
      }
    }
  }
  
  private String c(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    String[] arrayOfString = paramString.split("-");
    int j;
    int i;
    if (arrayOfString.length >= 1)
    {
      j = 2147483647;
      i = j;
    }
    try
    {
      if (arrayOfString.length >= 2) {
        i = Integer.parseInt(arrayOfString[1]);
      }
      b(i);
      this.a.add(paramString);
      if (this.a.size() > 50) {
        this.a.remove(0);
      }
      return arrayOfString[0];
      return "";
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;)
      {
        i = j;
      }
    }
  }
  
  private int d(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int j = 2147483647;
    if (bool) {
      return 2147483647;
    }
    paramString = e(paramString);
    int i = j;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = paramString.split("-");
      i = j;
      if (paramString.length < 2) {}
    }
    try
    {
      i = Integer.parseInt(paramString[1]);
      return i;
    }
    catch (Throwable paramString) {}
    return 2147483647;
  }
  
  private String e(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("-");
    paramString = ((StringBuilder)localObject1).toString();
    localObject1 = this.a.iterator();
    Object localObject2;
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (((String)localObject2).startsWith(paramString))) {
        return localObject2;
      }
    }
    localObject1 = this.c.a(3).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (GetRecommendWords.CopyWriter)((Iterator)localObject1).next();
      if ((!TextUtils.isEmpty(((GetRecommendWords.CopyWriter)localObject2).info.get())) && (((GetRecommendWords.CopyWriter)localObject2).info.get().startsWith(paramString))) {
        return ((GetRecommendWords.CopyWriter)localObject2).info.get();
      }
    }
    return null;
  }
  
  public String a(List<GetRecommendWords.CopyWriter> paramList, boolean paramBoolean)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      String str = c(((GetRecommendWords.CopyWriter)paramList.remove(i)).info.get());
      if (!TextUtils.isEmpty(str)) {
        return str;
      }
      i -= 1;
    }
    if (paramBoolean)
    {
      if (this.b == null)
      {
        this.b = new ArrayList(7);
        this.b.add("海上生明月-7");
        this.b.add("沧海月明珠有泪-3");
        this.b.add("忽如一夜春风来-15");
        this.b.add("老夫聊发少年狂-15");
        this.b.add("莫笑农家腊酒浑-7");
        this.b.add("昔人已乘黄鹤去-7");
      }
      i = new Random().nextInt(this.b.size());
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("getRandomIdiom get backIdiom:");
        paramList.append(i);
        paramList.append(" backWordListSize:");
        paramList.append(this.b.size());
        QLog.i("ContinueChainBizImpl", 2, paramList.toString());
      }
      return c((String)this.b.get(i));
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
  
  public void b(String paramString)
  {
    b(d(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.ContinueChainBizImpl
 * JD-Core Version:    0.7.0.1
 */