package com.tencent.mobileqq.flashshow.list.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.mobileqq.flashshow.widgets.common.FSAsyncTextView;
import com.tencent.mobileqq.flashshow.widgets.common.FSSquareImageView;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qcircle.api.data.Option;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.picload.QCircleFeedPicLoader;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StNotice;
import qqcircle.QQCircleFeedBase.StLeftTxtRightButtonInfo;
import qqcircle.QQCircleFeedBase.StLeftTxtRightPicInfo;
import qqcircle.QQCircleFeedBase.StNoticeBusiData;
import qqcircle.QQCircleFeedBase.StNoticeButtonInfo;
import qqcircle.QQCircleFeedBase.StNoticePattonInfo;
import qqcircle.QQCircleFeedBase.StNoticePicInfo;
import qqcircle.QQCircleFeedBase.StNoticeTxtInfo;
import qqcircle.QQCircleFeedBase.StPlainTxtInfo;

public class FSBusinessMessagePresenter
  extends FSBaseMessagePresenter
{
  private ViewStub A;
  protected FSSquareImageView q;
  protected View r;
  protected View s;
  protected TextView t;
  protected View.OnClickListener u;
  protected QQCircleFeedBase.StNoticeTxtInfo v;
  protected QQCircleFeedBase.StNoticePicInfo w;
  protected QQCircleFeedBase.StNoticeButtonInfo x;
  protected int y;
  private ViewStub z;
  
  public FSBusinessMessagePresenter(int paramInt)
  {
    super(paramInt);
  }
  
  private void a(QQCircleFeedBase.StNoticeButtonInfo paramStNoticeButtonInfo)
  {
    this.x = paramStNoticeButtonInfo;
    if (!TextUtils.isEmpty(paramStNoticeButtonInfo.name.get()))
    {
      if (this.s == null)
      {
        localObject = this.A;
        if (localObject != null) {
          this.s = ((ViewStub)localObject).inflate();
        }
      }
      Object localObject = this.s;
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        this.t = ((TextView)this.s.findViewById(2131448586));
        this.t.setVisibility(0);
        this.t.setText(paramStNoticeButtonInfo.name.get());
        this.t.setOnClickListener(new FSBusinessMessagePresenter.HandleSchemeClickListener(this, paramStNoticeButtonInfo.schemaUrl.get(), 2));
      }
    }
  }
  
  private void a(QQCircleFeedBase.StNoticePicInfo paramStNoticePicInfo)
  {
    this.w = paramStNoticePicInfo;
    if (!TextUtils.isEmpty(paramStNoticePicInfo.picInfo.picUrl.get()))
    {
      if (this.r == null)
      {
        localObject = this.z;
        if (localObject != null) {
          this.r = ((ViewStub)localObject).inflate();
        }
      }
      Object localObject = this.r;
      if (localObject != null)
      {
        ((View)localObject).setVisibility(0);
        this.q = ((FSSquareImageView)this.r.findViewById(2131436373));
        this.r.setVisibility(0);
        this.q.setRoundRect(ViewUtils.dip2px(4.0F));
        if ((this.q.getTag(2131433864) instanceof String)) {
          localObject = (String)this.q.getTag(2131433864);
        } else {
          localObject = "";
        }
        String str = paramStNoticePicInfo.picInfo.picUrl.get();
        this.q.setTag(2131433864, str);
        if (!((String)localObject).equals(str))
        {
          localObject = new Option().setUrl(str).setTargetView(this.q).setFromPreLoad(false).setPredecode(true).setRequestWidth(this.q.getWidth()).setRequestHeight(this.q.getHeight());
          QCircleFeedPicLoader.g().loadImage((Option)localObject, new FSBusinessMessagePresenter.1(this));
        }
        this.r.setOnClickListener(new FSBusinessMessagePresenter.HandleSchemeClickListener(this, paramStNoticePicInfo.schemaUrl.get(), 2));
      }
    }
  }
  
  private void a(QQCircleFeedBase.StNoticeTxtInfo paramStNoticeTxtInfo)
  {
    this.v = paramStNoticeTxtInfo;
    this.h.setMaxLines(2);
    this.h.setEllipsize(TextUtils.TruncateAt.END);
    a(paramStNoticeTxtInfo.content.get());
    b(paramStNoticeTxtInfo.subContent.get());
    c(paramStNoticeTxtInfo.summary.get());
    this.u = new FSBusinessMessagePresenter.HandleSchemeClickListener(this, this.v.schemaUrl.get(), 1);
    this.g.setOnClickListener(this.u);
    this.h.setOnClickListener(this.u);
    this.m.setOnClickListener(this.u);
    this.p.setOnClickListener(this.u);
  }
  
  private void i()
  {
    View[] arrayOfView = new View[5];
    Object localObject = this.h;
    int i = 0;
    arrayOfView[0] = localObject;
    arrayOfView[1] = this.m;
    arrayOfView[2] = this.p;
    arrayOfView[3] = this.r;
    arrayOfView[4] = this.s;
    int j = arrayOfView.length;
    while (i < j)
    {
      localObject = arrayOfView[i];
      if (localObject != null) {
        ((View)localObject).setVisibility(8);
      }
      i += 1;
    }
  }
  
  void b(Context paramContext, View paramView)
  {
    this.z = ((ViewStub)paramView.findViewById(2131433879));
    this.A = ((ViewStub)paramView.findViewById(2131433880));
  }
  
  void b(FeedCloudMeta.StNotice paramStNotice, int paramInt)
  {
    i();
    if (this.e != null)
    {
      this.y = this.e.pattonInfo.pattonType.get();
      paramInt = this.y;
      if (paramInt == 1)
      {
        a((QQCircleFeedBase.StNoticeTxtInfo)this.e.pattonInfo.plainTxt.txtInfo.get());
        return;
      }
      if (paramInt == 2)
      {
        a((QQCircleFeedBase.StNoticeTxtInfo)this.e.pattonInfo.leftTxtRightPic.txtInfo.get());
        a((QQCircleFeedBase.StNoticePicInfo)this.e.pattonInfo.leftTxtRightPic.picInfo.get());
        return;
      }
      if (paramInt == 3)
      {
        a((QQCircleFeedBase.StNoticeTxtInfo)this.e.pattonInfo.leftTxtRightButton.txtInfo.get());
        a((QQCircleFeedBase.StNoticeButtonInfo)this.e.pattonInfo.leftTxtRightButton.buttonInfo.get());
        return;
      }
      paramStNotice = new StringBuilder();
      paramStNotice.append("error patternType:");
      paramStNotice.append(this.y);
      QLog.d("FSBusinessMessagePresenter", 1, paramStNotice.toString());
    }
  }
  
  void c() {}
  
  protected String f()
  {
    return "FSBusinessMessagePresenter";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.list.presenter.FSBusinessMessagePresenter
 * JD-Core Version:    0.7.0.1
 */