package com.tencent.mobileqq.kandian.biz.feeds.presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJStringUtils;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyView;
import com.tencent.mobileqq.kandian.biz.framework.RIJAppSetting;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderFriendRecommend;
import com.tencent.mobileqq.kandian.glue.report.RIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.dislike.DislikeInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.FixSizeImageView;
import com.tencent.widget.KandianNegativeWindow;
import com.tencent.widget.ListView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.articlesummary.articlesummary.FriendRecommendInfo;
import tencent.im.oidb.articlesummary.articlesummary.PackInfo;
import tencent.im.oidb.articlesummary.articlesummary.SpecialTopicInfo;

public class ReadInJoyHeaderPresenter
  implements View.OnClickListener, IReadInJoyPresenter
{
  private Context a;
  private ReadInJoyView b;
  private IReadInJoyModel c;
  private IFaceDecoder d;
  private ReadInJoyBaseAdapter e;
  private ListView f;
  private KandianNegativeWindow g;
  private boolean h;
  
  public ReadInJoyHeaderPresenter(Context paramContext, IFaceDecoder paramIFaceDecoder, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, ListView paramListView, KandianNegativeWindow paramKandianNegativeWindow)
  {
    this.a = paramContext;
    this.d = paramIFaceDecoder;
    this.e = paramReadInJoyBaseAdapter;
    this.g = paramKandianNegativeWindow;
    this.f = paramListView;
  }
  
  private URL a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.mHeaderIconUrl == null)
    {
      try
      {
        String str = ((articlesummary.SpecialTopicInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_icon_url.get();
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        localObject = null;
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic icon url empty");
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return null;
      }
      Object localObject = RIJConvertString2URL.b((String)localObject);
      paramAbsBaseArticleInfo.mHeaderIconUrl = ((URL)localObject);
      return localObject;
    }
    return paramAbsBaseArticleInfo.mHeaderIconUrl;
  }
  
  private void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, int paramInt, ArrayList<DislikeInfo> paramArrayList, Object paramObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int k = this.f.getChildCount();
    int j = 0;
    int i = 0;
    while (i < k)
    {
      IReadInJoyModel localIReadInJoyModel = (IReadInJoyModel)this.f.getChildAt(i).getTag(2131449867);
      ReadInJoyView localReadInJoyView = (ReadInJoyView)this.f.getChildAt(i).getTag(2131449873);
      if ((localIReadInJoyModel != null) && (localReadInJoyView != null) && (paramIReadInJoyModel.k().mGroupId == localIReadInJoyModel.k().mGroupId))
      {
        localArrayList1.add(localReadInJoyView);
        localArrayList2.add(localIReadInJoyModel);
      }
      i += 1;
    }
    paramReadInJoyView = new ReadInJoyHeaderPresenter.3(this, paramReadInJoyView, localArrayList2, paramArrayList, paramInt, paramObject);
    paramInt = j;
    while (paramInt < localArrayList1.size())
    {
      paramIReadInJoyModel = (Animation)((ReadInJoyView)localArrayList1.get(paramInt)).a().getTag(2131436721);
      if (paramInt != 0) {
        paramIReadInJoyModel.setAnimationListener(null);
      } else {
        paramIReadInJoyModel.setAnimationListener(paramReadInJoyView);
      }
      ((ReadInJoyView)localArrayList1.get(paramInt)).a().startAnimation(paramIReadInJoyModel);
      paramInt += 1;
    }
  }
  
  private void a(String paramString)
  {
    try
    {
      JSONObject localJSONObject = RIJTransMergeKanDianReport.d();
      localJSONObject.put("feeds_source", paramString);
      localJSONObject.put("kandian_mode", RIJAppSetting.b());
      IReadInJoyModel localIReadInJoyModel = this.c;
      String str = "0X800744D";
      paramString = str;
      if (localIReadInJoyModel != null)
      {
        paramString = str;
        if (ReadinjoyReportUtils.d(this.c.m())) {
          paramString = "0X8009357";
        }
      }
      PublicAccountReportUtils.a(null, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void a(boolean paramBoolean, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramBoolean)
    {
      localObject1 = d(paramAbsBaseArticleInfo);
      if ((localObject1 != null) && (((List)localObject1).size() == 1))
      {
        this.b.a.setOnClickListener(this);
        this.b.g.setTypeface(this.b.g.getTypeface(), 1);
      }
      else
      {
        this.b.a.setOnClickListener(null);
        this.b.g.setTypeface(this.b.g.getTypeface(), 0);
      }
    }
    else
    {
      this.b.a.setOnClickListener(this);
    }
    this.b.d.setVisibility(0);
    Object localObject1 = this.b.e;
    int k = 8;
    if (paramBoolean) {
      i = 8;
    } else {
      i = 0;
    }
    ((KandianUrlImageView)localObject1).setVisibility(i);
    this.b.e.setOnClickListener(this);
    localObject1 = this.b.f;
    int m = localObject1.length;
    int i = 0;
    while (i < m)
    {
      Object localObject2 = localObject1[i];
      int j;
      if (paramBoolean) {
        j = 0;
      } else {
        j = 8;
      }
      localObject2.setVisibility(j);
      i += 1;
    }
    localObject1 = this.b.g;
    if ((paramBoolean) && (d(paramAbsBaseArticleInfo).size() != 1)) {
      i = 8;
    } else {
      i = 0;
    }
    ((TextView)localObject1).setVisibility(i);
    this.b.g.setOnClickListener(this);
    paramAbsBaseArticleInfo = this.b.h;
    i = k;
    if (paramBoolean) {
      i = 0;
    }
    paramAbsBaseArticleInfo.setVisibility(i);
    this.b.i.setVisibility(0);
  }
  
  private String b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    try
    {
      paramAbsBaseArticleInfo = ((articlesummary.SpecialTopicInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_title.get();
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
      paramAbsBaseArticleInfo = null;
    }
    if (TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
      QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic title empty");
    }
    return paramAbsBaseArticleInfo;
  }
  
  private String c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    try
    {
      paramAbsBaseArticleInfo = ((articlesummary.SpecialTopicInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_special_topic_info.get()).str_header_jump_url.get();
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
      paramAbsBaseArticleInfo = null;
    }
    if (TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
      QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader special topic url empty");
    }
    return paramAbsBaseArticleInfo;
  }
  
  private List<Long> d(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.addAll(((articlesummary.FriendRecommendInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).rpt_recommenders.get());
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
    }
    if (localArrayList.isEmpty()) {
      QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader friend recommend uin list empty");
    }
    return localArrayList;
  }
  
  private String e(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    try
    {
      paramAbsBaseArticleInfo = ((articlesummary.FriendRecommendInfo)paramAbsBaseArticleInfo.mPackInfoObj.msg_friend_recommend_info.get()).str_header_title.get();
    }
    catch (Exception paramAbsBaseArticleInfo)
    {
      paramAbsBaseArticleInfo.printStackTrace();
      paramAbsBaseArticleInfo = null;
    }
    if (TextUtils.isEmpty(paramAbsBaseArticleInfo)) {
      QLog.w("ReadInJoyHeaderPresenter", 1, "ReadInJoyHeader friend recommend description empty");
    }
    return paramAbsBaseArticleInfo;
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel)
  {
    paramReadInJoyView = paramIReadInJoyModel.k();
    paramIReadInJoyModel = d(paramReadInJoyView);
    int i = 0;
    while (i < Math.min(4, paramIReadInJoyModel.size()))
    {
      if (RIJQQAppInterfaceUtil.g()) {
        this.b.f[i].setImageDrawable(SearchUtils.a(this.d, String.valueOf(paramIReadInJoyModel.get(i)), 1));
      } else {
        this.b.f[i].setImageBitmap(this.e.d(((Long)paramIReadInJoyModel.get(i)).longValue()));
      }
      String str = String.valueOf(paramIReadInJoyModel.get(i));
      this.b.f[i].setOnClickListener(new ReadInJoyHeaderPresenter.2(this, str, paramReadInJoyView));
      i += 1;
    }
    i = Math.min(4, paramIReadInJoyModel.size());
    while (i < 4)
    {
      this.b.f[i].setVisibility(8);
      i += 1;
    }
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, int paramInt)
  {
    this.b = paramReadInJoyView;
    this.c = paramIReadInJoyModel;
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.c.k();
    Object localObject;
    if (this.b.a != null)
    {
      localObject = this.b.b;
      if (this.c.a()) {
        paramInt = 0;
      } else {
        paramInt = 8;
      }
      ((View)localObject).setVisibility(paramInt);
    }
    if (this.c.a())
    {
      this.b.b();
      if (this.c.b() == 3)
      {
        this.b.a.setVisibility(8);
        this.b.k.setVisibility(8);
        if (this.b.l != null) {
          this.b.l.setVisibility(8);
        }
        this.b.c.setVisibility(0);
        this.b.c.setLogic(this.e, this.d);
        this.b.c.a(paramIReadInJoyModel);
        return;
      }
      this.b.c.setVisibility(8);
      this.b.a.setVisibility(0);
      paramInt = this.c.b();
      if (paramInt != 1)
      {
        if (paramInt == 2)
        {
          this.h = true;
          a(true, localAbsBaseArticleInfo);
          a(paramReadInJoyView, paramIReadInJoyModel);
          localObject = d(localAbsBaseArticleInfo);
          if (((List)localObject).size() == 1)
          {
            if (RIJQQAppInterfaceUtil.g()) {
              localObject = ContactUtils.d((QQAppInterface)ReadInJoyUtils.b(), String.valueOf(((List)localObject).get(0)));
            } else {
              localObject = this.e.e(((Long)((List)localObject).get(0)).longValue());
            }
            this.b.g.setText(RIJStringUtils.a((String)localObject));
          }
          this.b.h.setText(e(localAbsBaseArticleInfo));
        }
      }
      else
      {
        this.h = false;
        a(false, localAbsBaseArticleInfo);
        localObject = a(localAbsBaseArticleInfo);
        if (localObject == null)
        {
          this.b.e.setVisibility(8);
          this.b.d.setVisibility(8);
        }
        else
        {
          ReadInJoyDisplayUtils.a(this.b.e, (URL)localObject, this.a);
        }
        this.b.g.setText(b(localAbsBaseArticleInfo));
      }
      this.b.i.setOnClickListener(new ReadInJoyHeaderPresenter.1(this, paramIReadInJoyModel, paramReadInJoyView));
    }
  }
  
  public void a(ReadInJoyView paramReadInJoyView, IReadInJoyModel paramIReadInJoyModel, long paramLong, Bitmap paramBitmap)
  {
    if (this.c.b() == 3)
    {
      this.b.c.a(paramLong, paramBitmap);
      return;
    }
    if (this.b.a != null)
    {
      if (this.c.b() != 2) {
        return;
      }
      if (RIJQQAppInterfaceUtil.g())
      {
        paramReadInJoyView = d(paramIReadInJoyModel.k());
        if ((paramReadInJoyView.size() > 0) && (paramReadInJoyView.contains(Long.valueOf(paramLong))))
        {
          int i = paramReadInJoyView.indexOf(Long.valueOf(paramLong));
          this.b.f[i].setImageBitmap(paramBitmap);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    StringBuilder localStringBuilder;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131444231: 
      if (!this.h)
      {
        paramView = c(this.c.k());
        if (!TextUtils.isEmpty(paramView)) {
          ReadInJoyUtils.a(this.a, paramView);
        }
      }
      else
      {
        paramView = d(this.c.k());
        if (!paramView.isEmpty())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(ReadInJoyConstants.h);
          localStringBuilder.append(Base64Util.encodeToString(String.valueOf(paramView.get(0)).getBytes(), 2));
          paramView = localStringBuilder.toString();
          ReadInJoyUtils.a(this.a, paramView);
        }
      }
      break;
    case 2131428807: 
    case 2131444219: 
    case 2131444240: 
      if (this.h)
      {
        paramView = d(this.c.k());
        if ((paramView != null) && (paramView.size() == 1))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(ReadInJoyConstants.h);
          localStringBuilder.append(Base64Util.encodeToString(String.valueOf(paramView.get(0)).getBytes(), 2));
          paramView = localStringBuilder.toString();
          ReadInJoyUtils.a(this.a, paramView);
        }
      }
      else
      {
        paramView = c(this.c.k());
        if (!TextUtils.isEmpty(paramView)) {
          ReadInJoyUtils.a(this.a, paramView);
        }
      }
      break;
    }
    a(RIJFeedsType.k(this.c.k()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.presenter.ReadInJoyHeaderPresenter
 * JD-Core Version:    0.7.0.1
 */