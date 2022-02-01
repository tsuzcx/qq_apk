package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.utils.ReadInJoyTimeUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.common.api.impl.PublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyHeadImageView;
import com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyNickNameTextView;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.pts.ReadInJoyModelImpl;
import com.tencent.mobileqq.kandian.biz.push.RIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.glue.report.ReadinjoyReportUtils;
import com.tencent.mobileqq.kandian.repo.common.RIJConvertString2URL;
import com.tencent.mobileqq.kandian.repo.common.RIJItemViewTypeUtils;
import com.tencent.mobileqq.kandian.repo.common.constant.ReadInJoyConstants;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.PolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.mobileqq.kandian.repo.feeds.ReadInJoyObserver;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.FeedsInfoUser;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.report.UserOperationModule;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class ComponentHeaderPolymeric
  extends ComponentHeaderBase
  implements View.OnClickListener
{
  protected ReadInJoyObserver e = new ComponentHeaderPolymeric.6(this);
  private ReadInJoyNickNameTextView f;
  private TextView g;
  private ReadInJoyHeadImageView h;
  private View i;
  private LinearLayout j;
  private TextView k;
  private TextView l;
  private ImageView m;
  private View n;
  private long o;
  private boolean p = true;
  
  public ComponentHeaderPolymeric(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentHeaderPolymeric(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentHeaderPolymeric(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1)
    {
      a(false);
      QQToast.makeText(getContext(), HardCodeUtil.a(2131900501), 0).show();
      return;
    }
    if (paramInt == 2)
    {
      a(true);
      QQToast.makeText(getContext(), HardCodeUtil.a(2131900506), 0).show();
    }
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    paramAbsBaseArticleInfo.mPolymericInfo.p = paramInt;
    Object localObject = paramAbsBaseArticleInfo.mGroupSubArticleList;
    boolean bool = false;
    localObject = ((AbsBaseArticleInfo)((List)localObject).get(0)).mSocialFeedInfo;
    if (localObject != null) {
      ((SocializeFeedsInfo)localObject).o = paramInt;
    }
    localObject = ReadInJoyLogicEngineEventDispatcher.a();
    long l1 = paramAbsBaseArticleInfo.mPolymericInfo.f;
    if (paramAbsBaseArticleInfo.mPolymericInfo.p == 2) {
      bool = true;
    }
    ((ReadInJoyLogicEngineEventDispatcher)localObject).b(l1, bool);
    ThreadManager.post(new ComponentHeaderPolymeric.5(this, paramAbsBaseArticleInfo, paramInt), 5, null, true);
  }
  
  private void a(AppRuntime paramAppRuntime, String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("followUGCAccount followUin = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", followStatus = ");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mPolymericInfo.p);
      ((StringBuilder)localObject).append(", articleInfoID = ");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mArticleID);
      QLog.d("ComponentHeaderPolymeric", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = ReadInJoyLogicEngine.a().c();
    paramAppRuntime = paramAppRuntime.getAccount();
    boolean bool;
    if (paramAbsBaseArticleInfo.mPolymericInfo.p != 2) {
      bool = true;
    } else {
      bool = false;
    }
    ((UserOperationModule)localObject).request0x978(paramAppRuntime, paramString, bool, paramAbsBaseArticleInfo.mPolymericInfo.g, new ComponentHeaderPolymeric.1(this, paramAbsBaseArticleInfo), 2);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.l.setBackgroundResource(2130851325);
      this.l.setText(HardCodeUtil.a(2131900447));
      this.l.setTextColor(-2147483648);
      this.l.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
      return;
    }
    this.l.setBackgroundResource(2130851324);
    this.l.setText(HardCodeUtil.a(2131899712));
    this.l.setTextColor(-1);
    this.l.setCompoundDrawablePadding(AIOUtils.b(3.0F, getResources()));
    this.l.setCompoundDrawablesWithIntrinsicBounds(2130851322, 0, 0, 0);
  }
  
  private void b(AppRuntime paramAppRuntime, String paramString, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("followPGCAccount followUin = ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", followStatus = ");
      localStringBuilder.append(paramAbsBaseArticleInfo.mPolymericInfo.p);
      localStringBuilder.append(", articleInfoID = ");
      localStringBuilder.append(paramAbsBaseArticleInfo.mArticleID);
      QLog.d("ComponentHeaderPolymeric", 2, localStringBuilder.toString());
    }
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      paramAppRuntime = (QQAppInterface)paramAppRuntime;
      if (paramAbsBaseArticleInfo.mPolymericInfo.p == 1)
      {
        ReadInJoyLogicEngine.a().c().request0x978(paramAppRuntime.getAccount(), paramString, true, paramAbsBaseArticleInfo.mPolymericInfo.g, new ComponentHeaderPolymeric.2(this, paramAbsBaseArticleInfo), 1);
        return;
      }
      if (paramAbsBaseArticleInfo.mPolymericInfo.p == 2) {
        ReadInJoyLogicEngine.a().c().request0x978(paramAppRuntime.getAccount(), paramString, false, paramAbsBaseArticleInfo.mPolymericInfo.g, new ComponentHeaderPolymeric.3(this, paramAbsBaseArticleInfo), 1);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("ComponentHeaderPolymeric", 2, "followPGCAccount fail, appInterface is null!");
    }
  }
  
  private void c(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8008F55", "0X8008F55", 0, 0, "", "", "", RIJKanDianFolderStatus.getPolymericCommonR5Report(paramAbsBaseArticleInfo.mPolymericInfo).toString(), false);
    if (RIJFeedsType.G(paramAbsBaseArticleInfo))
    {
      AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.mGroupSubArticleList.get(0);
      String str1 = ReadinjoyReportUtils.a(getContext(), localAbsBaseArticleInfo.mArticleID, localAbsBaseArticleInfo.mAlgorithmID, 54, this.b.c(), localAbsBaseArticleInfo.getInnerUniqueID(), localAbsBaseArticleInfo.getVideoVid(), ReadinjoyReportUtils.a(localAbsBaseArticleInfo), localAbsBaseArticleInfo.videoReportInfo);
      String str2 = ReadinjoyReportUtils.e(paramAbsBaseArticleInfo.mChannelID);
      PublicAccountReportUtils.a(null, "CliOper", "", String.valueOf(paramAbsBaseArticleInfo.mPolymericInfo.f), str2, str2, 0, 0, Long.toString(localAbsBaseArticleInfo.mFeedId), String.valueOf(localAbsBaseArticleInfo.mArticleID), Integer.toString(localAbsBaseArticleInfo.mStrategyId), str1, false);
      return;
    }
    RIJFrameworkReportManager.b(paramAbsBaseArticleInfo, this.b.c());
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626192, this, true);
  }
  
  String a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    String str;
    if (paramAbsBaseArticleInfo.mPolymericInfo.c > 0L) {
      str = ReadInJoyTimeUtils.INSTANCE.getRelativeDisplayForTime(paramAbsBaseArticleInfo.mPolymericInfo.c, true);
    } else {
      str = HardCodeUtil.a(2131900465);
    }
    Object localObject = str;
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mPolymericInfo.d))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(" ");
      ((StringBuilder)localObject).append(paramAbsBaseArticleInfo.mPolymericInfo.d);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public void a()
  {
    super.a();
  }
  
  public void a(long paramLong, Bitmap paramBitmap)
  {
    if (this.o != paramLong) {
      return;
    }
    this.h.setImageBitmap(paramBitmap);
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.n = paramView.findViewById(2131447724);
    this.f = ((ReadInJoyNickNameTextView)paramView.findViewById(2131444229));
    this.g = ((TextView)paramView.findViewById(2131444221));
    this.h = ((ReadInJoyHeadImageView)paramView.findViewById(2131444224));
    this.j = ((LinearLayout)paramView.findViewById(2131444232));
    this.k = ((TextView)paramView.findViewById(2131444233));
    this.l = ((TextView)paramView.findViewById(2131444223));
    this.m = ((ImageView)findViewById(2131444225));
    this.i = paramView.findViewById(2131445137);
    this.i.setOnClickListener(this);
    this.h.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.l.setOnClickListener(this);
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    super.a(paramCellListener);
  }
  
  void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    int i1 = paramAbsBaseArticleInfo.mPolymericInfo.e;
    if (i1 != 6)
    {
      boolean bool = false;
      switch (i1)
      {
      default: 
        this.f.setText(paramAbsBaseArticleInfo.mPolymericInfo.b);
        this.g.setText(paramString);
        this.o = 0L;
        if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mPolymericInfo.g)) {
          break;
        }
        this.h.setImage(RIJConvertString2URL.b(paramAbsBaseArticleInfo.mPolymericInfo.g));
        paramString = this.h;
        if (paramAbsBaseArticleInfo.mPolymericInfo.j == 0) {
          bool = true;
        }
        paramString.setRound(bool);
        return;
      case 11: 
        this.g.setText(paramAbsBaseArticleInfo.mPolymericInfo.d);
        this.o = paramAbsBaseArticleInfo.mPolymericInfo.f;
        if ((paramAbsBaseArticleInfo.mGroupSubArticleList == null) || (paramAbsBaseArticleInfo.mGroupSubArticleList.size() <= 0)) {
          break;
        }
        paramString = (AbsBaseArticleInfo)paramAbsBaseArticleInfo.mGroupSubArticleList.get(0);
        if (((paramString instanceof BaseArticleInfo)) && (RIJItemViewTypeUtils.v(paramString)))
        {
          this.f.setText(paramAbsBaseArticleInfo.mPolymericInfo.b);
          this.h.setImageDrawable(SearchUtils.a(this.c, String.valueOf(this.o), 1));
          return;
        }
        this.h.setHeadImgByUin(this.o);
        this.f.setNickNameByUin(this.o);
        return;
      case 10: 
        this.k.setText(paramAbsBaseArticleInfo.mPolymericInfo.d);
        return;
      case 9: 
        Object localObject = paramAbsBaseArticleInfo.mPolymericInfo.b;
        if (((String)localObject).startsWith("#"))
        {
          paramString = (String)localObject;
          if (!((String)localObject).startsWith("# "))
          {
            paramString = new StringBuilder();
            paramString.append("# ");
            paramString.append(((String)localObject).substring(1));
            paramString = paramString.toString();
          }
          paramString = new SpannableString(paramString);
          paramString.setSpan(new ForegroundColorSpan(getResources().getColor(2131167836)), 0, 1, 33);
          paramString.setSpan(new ImageSpan(getContext(), 2130843983), 1, 2, 33);
          this.f.setText(paramString);
        }
        else
        {
          this.f.setText(paramAbsBaseArticleInfo.mPolymericInfo.b);
        }
        this.g.setText(paramAbsBaseArticleInfo.mPolymericInfo.d);
        this.o = 0L;
        if (TextUtils.isEmpty(paramAbsBaseArticleInfo.mPolymericInfo.g)) {
          break;
        }
        paramString = URLDrawable.URLDrawableOptions.obtain();
        localObject = new ColorDrawable(0);
        paramString.mFailedDrawable = ((Drawable)localObject);
        paramString.mLoadingDrawable = ((Drawable)localObject);
        paramAbsBaseArticleInfo = URLDrawable.getDrawable(RIJConvertString2URL.b(paramAbsBaseArticleInfo.mPolymericInfo.g), paramString);
        paramAbsBaseArticleInfo.setTag(URLDrawableDecodeHandler.b(72, 72, DisplayUtil.a(this.h.getContext(), 2.0F)));
        paramAbsBaseArticleInfo.setDecodeHandler(URLDrawableDecodeHandler.j);
        this.h.setImageDrawable(paramAbsBaseArticleInfo);
        return;
      }
    }
    else
    {
      this.f.setText(paramAbsBaseArticleInfo.mPolymericInfo.b);
      this.g.setText(paramString);
      this.o = paramAbsBaseArticleInfo.mPolymericInfo.f;
      this.h.setImageDrawable(SearchUtils.a(this.c, String.valueOf(this.o), 1));
    }
  }
  
  public void a(Object paramObject)
  {
    super.a(paramObject);
    AbsBaseArticleInfo localAbsBaseArticleInfo = ((IReadInJoyModel)paramObject).k();
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mPolymericInfo != null))
    {
      String str = a(localAbsBaseArticleInfo);
      b(localAbsBaseArticleInfo);
      a(localAbsBaseArticleInfo, str);
    }
    a(paramObject, localAbsBaseArticleInfo);
  }
  
  void a(Object paramObject, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mGroupSubArticleList != null) && (!paramAbsBaseArticleInfo.mGroupSubArticleList.isEmpty()) && (paramAbsBaseArticleInfo.mPolymericInfo != null))
    {
      int i3 = paramAbsBaseArticleInfo.mPolymericInfo.p;
      int i1 = 1;
      int i2 = 1;
      if ((i3 == 2) || (paramAbsBaseArticleInfo.mPolymericInfo.p == 1))
      {
        this.p = true;
        if (paramAbsBaseArticleInfo.mPolymericInfo.e == 11)
        {
          if (paramAbsBaseArticleInfo.mPolymericInfo.p == 2) {
            i1 = 1;
          } else {
            i1 = 0;
          }
          this.l.setTag(String.valueOf(paramAbsBaseArticleInfo.mPolymericInfo.f));
          paramAbsBaseArticleInfo = ((AbsBaseArticleInfo)paramAbsBaseArticleInfo.mGroupSubArticleList.get(0)).mSocialFeedInfo;
          if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.c != null))
          {
            if (paramAbsBaseArticleInfo.c != null)
            {
              if (paramAbsBaseArticleInfo.c.b == 1) {
                this.m.setVisibility(0);
              } else {
                this.m.setVisibility(8);
              }
            }
            else {
              this.m.setVisibility(8);
            }
          }
          else {
            this.l.setVisibility(8);
          }
        }
        else if (paramAbsBaseArticleInfo.mPolymericInfo.e == 9)
        {
          if (paramAbsBaseArticleInfo.mPolymericInfo.p == 2) {
            i1 = i2;
          } else {
            i1 = 0;
          }
          this.l.setTag(String.valueOf(paramAbsBaseArticleInfo.mPolymericInfo.m));
        }
        if (i1 == 0)
        {
          this.l.setVisibility(0);
          a(false);
        }
        else
        {
          this.l.setVisibility(8);
        }
        paramAbsBaseArticleInfo = (LinearLayout.LayoutParams)this.l.getLayoutParams();
        if (c()) {
          paramAbsBaseArticleInfo.rightMargin = DisplayUtil.a(getContext(), 12.0F);
        } else {
          paramAbsBaseArticleInfo.rightMargin = DisplayUtil.a(getContext(), 0.0F);
        }
        this.l.setLayoutParams(paramAbsBaseArticleInfo);
        if ((paramObject instanceof ReadInJoyModelImpl))
        {
          paramObject = (ReadInJoyModelImpl)paramObject;
          if ((paramObject.m() == 56) && (paramObject.b != 0))
          {
            this.n.setVisibility(0);
            return;
          }
          this.n.setVisibility(8);
          return;
        }
        this.n.setVisibility(8);
        return;
      }
    }
    this.l.setVisibility(8);
    if ((QLog.isColorLevel()) && (paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mPolymericInfo != null))
    {
      paramObject = new StringBuilder();
      paramObject.append("articleInfo.mPolymericInfo = ");
      paramObject.append(paramAbsBaseArticleInfo.mPolymericInfo.toString());
      QLog.d("ComponentHeaderPolymeric", 2, paramObject.toString());
    }
  }
  
  void b(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo.mPolymericInfo.e == 10)
    {
      this.n.setVisibility(8);
      this.k.setVisibility(8);
      this.j.setVisibility(8);
      this.h.setVisibility(8);
      return;
    }
    this.k.setVisibility(8);
    this.j.setVisibility(0);
    this.h.setVisibility(0);
  }
  
  public boolean c()
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
    if ((localAbsBaseArticleInfo != null) && (localAbsBaseArticleInfo.mPolymericInfo != null) && ((this.a.a instanceof ReadInJoyModelImpl)))
    {
      ReadInJoyModelImpl localReadInJoyModelImpl = (ReadInJoyModelImpl)this.a.a;
      int i1 = localAbsBaseArticleInfo.mPolymericInfo.e;
      if (((i1 == 9) || (i1 == 10) || (i1 == 11)) && (localReadInJoyModelImpl.a == 56)) {
        return true;
      }
      if (i1 == 10) {
        return true;
      }
    }
    return super.c();
  }
  
  protected void e()
  {
    AppRuntime localAppRuntime = ReadInJoyUtils.b();
    if (localAppRuntime != null)
    {
      int i1 = 0;
      this.p = false;
      AbsBaseArticleInfo localAbsBaseArticleInfo1 = this.a.a.k();
      if (ReadinjoyReportUtils.d(this.a.a.m())) {
        str = "0X800941D";
      } else {
        str = "0X80080EC";
      }
      RIJFrameworkReportManager.a(localAbsBaseArticleInfo1, str, str, this.a.a.m());
      ReadInJoyLogicEngine.e(localAbsBaseArticleInfo1);
      String str = String.valueOf(localAbsBaseArticleInfo1.mPolymericInfo.f);
      if ((localAbsBaseArticleInfo1.mGroupSubArticleList != null) && (localAbsBaseArticleInfo1.mGroupSubArticleList.size() > 0))
      {
        AbsBaseArticleInfo localAbsBaseArticleInfo2 = (AbsBaseArticleInfo)localAbsBaseArticleInfo1.mGroupSubArticleList.get(0);
        if (((localAbsBaseArticleInfo2 instanceof BaseArticleInfo)) && (RIJItemViewTypeUtils.v(localAbsBaseArticleInfo2))) {}
      }
      else
      {
        i1 = 1;
      }
      if (i1 != 0)
      {
        a(localAppRuntime, str, localAbsBaseArticleInfo1);
        return;
      }
      b(localAppRuntime, str, localAbsBaseArticleInfo1);
    }
  }
  
  protected void f()
  {
    Object localObject1 = ReadInJoyUtils.b();
    AbsBaseArticleInfo localAbsBaseArticleInfo = (AbsBaseArticleInfo)this.a.a.k().mGroupSubArticleList.get(0);
    localObject1 = ((AppRuntime)localObject1).getAccount();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("followPGCAccount topicID = ");
      ((StringBuilder)localObject2).append(localAbsBaseArticleInfo.mPolymericInfo.m);
      ((StringBuilder)localObject2).append(", followStatus = ");
      ((StringBuilder)localObject2).append(localAbsBaseArticleInfo.mPolymericInfo.p);
      ((StringBuilder)localObject2).append(", articleInfoID = ");
      ((StringBuilder)localObject2).append(localAbsBaseArticleInfo.mArticleID);
      QLog.d("ComponentHeaderPolymeric", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = ReadInJoyLogicEngine.a().c();
    String str = Long.toString(localAbsBaseArticleInfo.mPolymericInfo.m);
    boolean bool;
    if (localAbsBaseArticleInfo.mPolymericInfo.p != 2) {
      bool = true;
    } else {
      bool = false;
    }
    ((UserOperationModule)localObject2).request0x978((String)localObject1, str, bool, localAbsBaseArticleInfo.mPolymericInfo.g, new ComponentHeaderPolymeric.4(this, localAbsBaseArticleInfo), 3);
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.e);
  }
  
  public void onClick(View paramView)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = this.a.a.k();
    switch (paramView.getId())
    {
    default: 
    case 2131444224: 
    case 2131444229: 
      switch (localAbsBaseArticleInfo.mPolymericInfo.e)
      {
      case 10: 
      default: 
        break;
      case 11: 
        paramView = new StringBuilder();
        paramView.append(ReadInJoyConstants.l);
        paramView.append(Base64Util.encodeToString(String.valueOf(localAbsBaseArticleInfo.mPolymericInfo.f).getBytes(), 2));
        paramView = paramView.toString();
        ReadInJoyUtils.a(getContext(), paramView);
        break;
      case 7: 
      case 8: 
      case 9: 
        ReadInJoyUtils.a(getContext(), localAbsBaseArticleInfo.mPolymericInfo.i);
        break;
      case 6: 
        paramView = new StringBuilder();
        paramView.append(ReadInJoyConstants.h);
        paramView.append(Base64Util.encodeToString(String.valueOf(localAbsBaseArticleInfo.mPolymericInfo.f).getBytes(), 2));
        paramView = paramView.toString();
        ReadInJoyUtils.a(getContext(), paramView);
      }
      c(localAbsBaseArticleInfo);
      return;
    case 2131444223: 
      if ((localAbsBaseArticleInfo.mPolymericInfo.p != 2) && (localAbsBaseArticleInfo.mPolymericInfo.p != 1)) {
        return;
      }
      if (!this.p)
      {
        QQToast.makeText(getContext(), HardCodeUtil.a(2131900466), 0).show();
        if (QLog.isColorLevel()) {
          QLog.d("ComponentHeaderPolymeric", 2, "click when the button is disabled");
        }
        return;
      }
      if (localAbsBaseArticleInfo.mPolymericInfo.e == 11)
      {
        e();
        return;
      }
      if (localAbsBaseArticleInfo.mPolymericInfo.e == 9) {
        f();
      }
      break;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderPolymeric
 * JD-Core Version:    0.7.0.1
 */