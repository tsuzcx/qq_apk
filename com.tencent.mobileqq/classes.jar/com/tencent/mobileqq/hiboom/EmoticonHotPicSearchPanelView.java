package com.tencent.mobileqq.hiboom;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.api.IEmotionSearchManagerService;
import com.tencent.mobileqq.emosm.emosearch.IEmoticonSearchHelper;
import com.tencent.mobileqq.emosm.emosearch.IRichTextPanelEmoticonSearchLayoutHelper;
import com.tencent.mobileqq.emosm.emosearch.api.IRichTextPanelSearchHelperApi;
import com.tencent.mobileqq.emoticonview.AIOEmoticonPanelHelper;
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonPanelOnScrollListener;
import com.tencent.mobileqq.emoticonview.EmotionPanelListView;
import com.tencent.mobileqq.emoticonview.EmotionPanelViewPool;
import com.tencent.mobileqq.emoticonview.IEmotionHotPicSearchAdapter;
import com.tencent.mobileqq.emoticonview.api.IEmoticonMainPanelAppService;
import com.tencent.mobileqq.emoticonview.api.impl.AIOPanelInteractionListener;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XEditTextEx;
import java.util.ArrayList;

public class EmoticonHotPicSearchPanelView
  extends RichTextPanelView
{
  private BaseChatPie a;
  private RichTextPanelExtendHelper b;
  private EmotionPanelListView c;
  private IEmotionHotPicSearchAdapter d;
  private IEmoticonSearchHelper e;
  
  public EmoticonHotPicSearchPanelView(Context paramContext, BaseChatPie paramBaseChatPie, RichTextPanelExtendHelper paramRichTextPanelExtendHelper)
  {
    super(paramContext);
    this.a = paramBaseChatPie;
    this.b = paramRichTextPanelExtendHelper;
    this.e = ((IRichTextPanelSearchHelperApi)QRoute.api(IRichTextPanelSearchHelperApi.class)).createSearchHelper(new AIOPanelInteractionListener(this.a), paramContext, paramRichTextPanelExtendHelper);
    d();
  }
  
  private void d()
  {
    this.c = new EmotionPanelListView(getContext());
    this.c.setVerticalScrollBarEnabled(false);
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    localRelativeLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
    localRelativeLayout.addView(this.c, new RelativeLayout.LayoutParams(-1, -1));
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    Object localObject1 = View.inflate(getContext(), 2131624089, null);
    localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    localObject2 = (AIOEmoticonPanelHelper)this.a.q(104);
    this.d = ((IRichTextPanelSearchHelperApi)QRoute.api(IRichTextPanelSearchHelperApi.class)).createSearchAdapter(((IEmoticonMainPanelAppService)QRoute.api(IEmoticonMainPanelAppService.class)).createEmoticonMainPanelApp(this.a.d), new AIOPanelInteractionListener(this.a), getContext(), 4, 14, 12, (EmoticonCallback)localObject2);
    this.c.setDivider(null);
    this.c.setEdgeEffectEnabled(false);
    this.c.setSelector(2130853313);
    this.d.setWidthPixels(ViewUtils.getScreenWidth());
    this.d.setCurrentListView(this.c);
    ((IRichTextPanelEmoticonSearchLayoutHelper)this.e).a(this.c, this.d);
    this.e.setEmptyView((View)localObject1);
    this.c.setAdapter(this.d);
    this.c.setEnableExtendPanle(true);
    this.c.setPullAndFastScrollListener(this.b);
    localObject1 = this.c;
    ((EmotionPanelListView)localObject1).setOnScrollListener(new EmoticonPanelOnScrollListener((EmotionPanelListView)localObject1, this.b, null));
    this.c.addOnScrollListener((AbsListView.OnScrollListener)this.e);
    addView(localRelativeLayout, new RelativeLayout.LayoutParams(-1, -1));
    if ((this.a.Y != null) && (this.a.Y.getText() != null)) {
      this.e.startSearch(this.a.Y.getText().toString());
    }
  }
  
  public void a()
  {
    if ((this.a.Y != null) && (this.a.Y.getText() != null))
    {
      String str1 = this.e.getSearchWord();
      String str2 = this.a.Y.getText().toString();
      if ((!StringUtil.isEmpty(str1)) && (str1.equals(str2)))
      {
        this.e.setLoadingStatus(3);
        return;
      }
      this.d.setData(new ArrayList());
      this.e.setSearchWords(str2);
      this.e.onShow();
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonHotPicSearchPanelView", 4, " reportDefaultExposedEvent ");
    }
    this.e.reportItemExposed();
  }
  
  public void b(boolean paramBoolean)
  {
    this.e.onHide(paramBoolean);
  }
  
  public void bO_()
  {
    super.bO_();
    if ((((IEmotionSearchManagerService)this.a.d.getRuntimeService(IEmotionSearchManagerService.class)).getSearchCallBack() instanceof IRichTextPanelEmoticonSearchLayoutHelper)) {
      this.e.resetEmoticonSearch();
    }
  }
  
  public String getName()
  {
    return getContext().getString(2131886502);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    EmotionPanelViewPool.getInstance().destory();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    paramInt1 = getMeasuredWidth();
    IEmotionHotPicSearchAdapter localIEmotionHotPicSearchAdapter = this.d;
    if ((localIEmotionHotPicSearchAdapter != null) && (localIEmotionHotPicSearchAdapter.getWidthPixels() != paramInt1))
    {
      this.d.setWidthPixels(paramInt1);
      this.c.setAdapter(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.hiboom.EmoticonHotPicSearchPanelView
 * JD-Core Version:    0.7.0.1
 */