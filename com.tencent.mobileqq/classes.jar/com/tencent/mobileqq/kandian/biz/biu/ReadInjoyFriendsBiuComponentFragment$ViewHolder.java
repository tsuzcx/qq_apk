package com.tencent.mobileqq.kandian.biz.biu;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.pts.component.CmpCtxt;
import com.tencent.mobileqq.kandian.glue.msf.api.IReadInJoyUserInfoModule.RefreshUserInfoCallBack;
import com.tencent.mobileqq.kandian.repo.biu.MultiBiuSameContent;
import com.tencent.mobileqq.kandian.repo.common.ReadInJoyUserInfoModule;
import com.tencent.mobileqq.kandian.repo.db.struct.SocializeFeedsInfoUtils;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ReadInJoyUserInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.text.QQText;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ReadInjoyFriendsBiuComponentFragment$ViewHolder
{
  View a;
  TextView b;
  TextView c;
  TextView d;
  ReadInJoyHeadImageView e;
  CmpCtxt f = new CmpCtxt();
  public String g;
  long h;
  long i;
  int j;
  ArrayList<BiuCommentInfo> k;
  IReadInJoyUserInfoModule.RefreshUserInfoCallBack l = new ReadInjoyFriendsBiuComponentFragment.ViewHolder.1(this);
  private final String n = "5";
  
  public ReadInjoyFriendsBiuComponentFragment$ViewHolder(ReadInjoyFriendsBiuComponentFragment paramReadInjoyFriendsBiuComponentFragment, Context paramContext)
  {
    a(paramContext);
    this.a.setTag(this);
  }
  
  private void a(long paramLong)
  {
    ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(paramLong, new ReadInjoyFriendsBiuComponentFragment.ViewHolder.2(this));
    String str = ReadInJoyUserInfoModule.d();
    if (localReadInJoyUserInfo != null) {
      str = localReadInJoyUserInfo.nick;
    }
    this.b.setText(str);
  }
  
  private void a(ArrayList<BiuCommentInfo> paramArrayList)
  {
    paramArrayList = SocializeFeedsInfoUtils.a(null, "5", this.l, paramArrayList);
    this.d.setSpannableFactory(QQText.SPANNABLE_FACTORY);
    this.d.setText(paramArrayList);
  }
  
  private boolean b(ArrayList<BiuCommentInfo> paramArrayList)
  {
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        if (!TextUtils.isEmpty(((BiuCommentInfo)paramArrayList.next()).mBiuComment)) {
          return false;
        }
      }
    }
    return true;
  }
  
  public View a()
  {
    return this.a;
  }
  
  public void a(Context paramContext)
  {
    this.a = LayoutInflater.from(paramContext).inflate(2131626256, null);
    this.e = ((ReadInJoyHeadImageView)this.a.findViewById(2131434914));
    this.b = ((TextView)this.a.findViewById(2131439303));
    this.d = ((TextView)this.a.findViewById(2131431033));
    this.c = ((TextView)this.a.findViewById(2131429573));
  }
  
  public void a(MultiBiuSameContent paramMultiBiuSameContent, int paramInt)
  {
    a(paramMultiBiuSameContent.a);
    this.d.setOnClickListener(this.m.f);
    Object localObject = ReadInJoyTimeUtils.INSTANCE.getRelativeDisplayForTime(paramMultiBiuSameContent.d, true);
    if (localObject != null) {
      this.c.setText((CharSequence)localObject);
    }
    this.e.setTag(Integer.valueOf(paramInt));
    this.e.setHeadImgByUin(paramMultiBiuSameContent.a);
    this.h = paramMultiBiuSameContent.a;
    this.j = paramMultiBiuSameContent.f;
    this.i = paramMultiBiuSameContent.e;
    this.d.setTag(Integer.valueOf(paramInt));
    this.b.setTag(Integer.valueOf(paramInt));
    this.b.setOnClickListener(this.m.f);
    this.e.setOnClickListener(this.m.f);
    this.g = ReadInjoyFriendsBiuComponentFragment.a(this.m, paramMultiBiuSameContent.a, paramMultiBiuSameContent.f, paramMultiBiuSameContent.e);
    try
    {
      if ((paramMultiBiuSameContent.i != null) && (!paramMultiBiuSameContent.i.isEmpty()))
      {
        this.k = paramMultiBiuSameContent.i;
        if (b(paramMultiBiuSameContent.i))
        {
          this.d.setVisibility(8);
          return;
        }
        a(this.k);
        return;
      }
      if (TextUtils.isEmpty(paramMultiBiuSameContent.b))
      {
        this.d.setVisibility(8);
        return;
      }
      localObject = new SpannableStringBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramMultiBiuSameContent.b);
      ((SpannableStringBuilder)localObject).append(new QQText(localStringBuilder, 7, 16));
      this.d.setText((CharSequence)localObject);
      return;
    }
    catch (Exception paramMultiBiuSameContent)
    {
      QLog.e("ReadInjoyFriendsBiuComponentFragment", 2, "setData: ", paramMultiBiuSameContent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.biu.ReadInjoyFriendsBiuComponentFragment.ViewHolder
 * JD-Core Version:    0.7.0.1
 */