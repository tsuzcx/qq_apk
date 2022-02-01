package com.tencent.mobileqq.kandian.biz.pts.component;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.kandian.biz.config.IReadInJoySearchJumpUrlConfBean;
import com.tencent.mobileqq.kandian.biz.framework.ReadInJoyBaseAdapter;
import com.tencent.mobileqq.kandian.biz.search.ReadInjoySearchJumpurlConfProcessor;
import com.tencent.mobileqq.kandian.repo.feeds.HotWordInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.widget.MeasureGridView;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ComponentContentHotSearch
  extends RelativeLayout
  implements ComponentInheritView
{
  public static final String a = "ComponentContentHotSearch";
  public static String b;
  private RelativeLayout c;
  private URLImageView d;
  private ComponentNotIntrest e;
  private MeasureGridView f;
  private ComponentContentHotSearch.HotWordsAdapter g;
  private AbsBaseArticleInfo h;
  private IReadInJoyModel i;
  private ReadInJoyBaseAdapter j;
  
  public ComponentContentHotSearch(Context paramContext, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter)
  {
    super(paramContext);
    this.j = paramReadInJoyBaseAdapter;
    b(paramContext);
  }
  
  public View a(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131626174, this, true);
  }
  
  public void a(View paramView)
  {
    this.c = ((RelativeLayout)paramView.findViewById(2131435170));
    this.d = ((URLImageView)paramView.findViewById(2131447511));
    this.e = ((ComponentNotIntrest)paramView.findViewById(2131439399));
    this.f = ((MeasureGridView)paramView.findViewById(2131435169));
    this.g = new ComponentContentHotSearch.HotWordsAdapter(this);
    this.f.setAdapter(this.g);
    this.c.setOnClickListener(new ComponentContentHotSearch.1(this));
  }
  
  public void a(FeedItemCell.CellListener paramCellListener)
  {
    ComponentNotIntrest localComponentNotIntrest = this.e;
    if (localComponentNotIntrest != null) {
      localComponentNotIntrest.a(paramCellListener);
    }
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof IReadInJoyModel))
    {
      this.i = ((IReadInJoyModel)paramObject);
      this.h = this.i.k();
      paramObject = this.h;
      if (paramObject == null) {
        return;
      }
      paramObject = paramObject.hotWordInfo;
      if ((paramObject != null) && (paramObject.a != null) && (paramObject.a.size() > 0))
      {
        this.g.a(paramObject.a);
        paramObject = ReadInjoySearchJumpurlConfProcessor.a();
        if ((paramObject != null) && (!TextUtils.isEmpty(paramObject.b()))) {
          paramObject = paramObject.b();
        } else {
          paramObject = "https://pub.idqqimg.com/pc/misc/files/20180903/eddc885537fc4606a66c93a06854511b.png";
        }
        Drawable localDrawable = URLDrawableHelperConstants.a;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mFailedDrawable = localDrawable;
        localURLDrawableOptions.mLoadingDrawable = localDrawable;
        localURLDrawableOptions.mRequestWidth = this.d.getWidth();
        localURLDrawableOptions.mRequestHeight = this.d.getHeight();
        paramObject = URLDrawable.getDrawable(paramObject, localURLDrawableOptions);
        this.d.setImageDrawable(paramObject);
        if ((paramObject.getStatus() != 1) && (paramObject.getStatus() != 0)) {
          paramObject.restartDownload();
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d(a, 2, "bindData hotWordInfo is null or hotWordItems is null ");
      }
    }
  }
  
  public void b(Context paramContext)
  {
    a(a(paramContext));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentContentHotSearch
 * JD-Core Version:    0.7.0.1
 */