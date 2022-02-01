package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.qwallet.hb.send.busylogic.IWordChainBiz;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tencent.im.qqwallet.GetRecommendWords.CopyWriter;

public class IdiomWordChainBizImpl
  implements IWordChainBiz
{
  private List<String> a;
  
  public String a(List<GetRecommendWords.CopyWriter> paramList, boolean paramBoolean)
  {
    int i = paramList.size() - 1;
    while (i >= 0)
    {
      GetRecommendWords.CopyWriter localCopyWriter = (GetRecommendWords.CopyWriter)paramList.remove(i);
      if ((!TextUtils.isEmpty(localCopyWriter.info.get())) && (localCopyWriter.info.get().length() == 4)) {
        return localCopyWriter.info.get();
      }
      i -= 1;
    }
    if (paramBoolean)
    {
      if (this.a == null)
      {
        this.a = new ArrayList();
        this.a.add(HardCodeUtil.a(R.string.aV));
        this.a.add(HardCodeUtil.a(R.string.ba));
        this.a.add(HardCodeUtil.a(R.string.aW));
        this.a.add(HardCodeUtil.a(R.string.bb));
        this.a.add(HardCodeUtil.a(R.string.aX));
        this.a.add(HardCodeUtil.a(R.string.aZ));
        this.a.add(HardCodeUtil.a(R.string.aT));
        this.a.add(HardCodeUtil.a(R.string.bg));
        this.a.add(HardCodeUtil.a(R.string.bd));
        this.a.add(HardCodeUtil.a(R.string.bf));
        this.a.add(HardCodeUtil.a(R.string.be));
      }
      i = new Random().nextInt(this.a.size());
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("getRandomIdiom get backIdiom:");
        paramList.append(i);
        paramList.append(" backIdiomListSize:");
        paramList.append(this.a.size());
        QLog.i("IdiomWordChainBizImpl", 2, paramList.toString());
      }
      return (String)this.a.get(i);
    }
    return "";
  }
  
  public void a(String paramString) {}
  
  public boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.length() == 4) && (HbBusiUtils.a(paramString) >= 4);
  }
  
  public InputFilter[] a(int paramInt)
  {
    int i;
    if ((!SystemUtil.d()) && (!SystemUtil.e())) {
      i = 0;
    } else {
      i = 1;
    }
    if ((i == 0) && (paramInt > 0)) {
      return new InputFilter[] { new InputFilter.LengthFilter(paramInt) };
    }
    return new InputFilter[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.IdiomWordChainBizImpl
 * JD-Core Version:    0.7.0.1
 */