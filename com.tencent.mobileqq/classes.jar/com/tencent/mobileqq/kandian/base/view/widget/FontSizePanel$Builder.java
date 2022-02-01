package com.tencent.mobileqq.kandian.base.view.widget;

import android.graphics.drawable.BitmapDrawable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.view.api.IFontSizePanelBuilder;
import com.tencent.widget.RangeButtonView;
import com.tencent.widget.RangeButtonView.OnChangeListener;
import com.tencent.widget.RangeButtonView.Title;
import java.util.ArrayList;
import java.util.List;

public class FontSizePanel$Builder
  implements IFontSizePanelBuilder
{
  private LayoutInflater a;
  private List<RangeButtonView.Title> b;
  private List<String> c;
  private RangeButtonView.OnChangeListener d;
  private int e;
  private boolean f = false;
  
  public FontSizePanel$Builder(LayoutInflater paramLayoutInflater)
  {
    this.a = paramLayoutInflater;
  }
  
  private float a(float paramFloat)
  {
    float f1 = TypedValue.applyDimension(1, 16.0F, FontSettingManager.systemMetrics);
    if (paramFloat == 15.0F) {
      return TypedValue.applyDimension(1, 15.0F, FontSettingManager.systemMetrics);
    }
    if (paramFloat == 17.0F) {
      return TypedValue.applyDimension(1, 17.0F, FontSettingManager.systemMetrics);
    }
    if (paramFloat == 18.0F) {
      return TypedValue.applyDimension(1, 18.0F, FontSettingManager.systemMetrics);
    }
    if (paramFloat == 20.0F) {
      f1 = TypedValue.applyDimension(1, 20.0F, FontSettingManager.systemMetrics);
    }
    return f1;
  }
  
  public Builder a(boolean paramBoolean)
  {
    this.f = paramBoolean;
    return this;
  }
  
  public Builder b(int paramInt)
  {
    this.e = paramInt;
    return this;
  }
  
  public Builder b(Object paramObject)
  {
    this.d = ((RangeButtonView.OnChangeListener)paramObject);
    return this;
  }
  
  public FontSizePanel b()
  {
    FontSizePanel localFontSizePanel = new FontSizePanel(null);
    Object localObject1 = this.a.inflate(2131624765, null);
    FontSizePanel.a(localFontSizePanel, new PopupWindow((View)localObject1, -1, -2));
    FontSizePanel.a(localFontSizePanel).setBackgroundDrawable(new BitmapDrawable());
    FontSizePanel.a(localFontSizePanel).setOutsideTouchable(true);
    localObject1 = (RangeButtonView)((View)localObject1).findViewById(2131433554);
    Object localObject2 = this.b;
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      this.b = new ArrayList();
      this.b.add(new RangeButtonView.Title(HardCodeUtil.a(2131902702), a(15.0F)));
      this.b.add(new RangeButtonView.Title(HardCodeUtil.a(2131902699), a(16.0F)));
      this.b.add(new RangeButtonView.Title("", a(17.0F)));
      this.b.add(new RangeButtonView.Title("", a(18.0F)));
      this.b.add(new RangeButtonView.Title(HardCodeUtil.a(2131900599), a(20.0F)));
    }
    ((RangeButtonView)localObject1).setTitleData(this.b);
    FontSizePanel.a(localFontSizePanel, this.b);
    localObject2 = this.d;
    if (localObject2 != null) {
      ((RangeButtonView)localObject1).setOnChangerListener((RangeButtonView.OnChangeListener)localObject2);
    }
    ((RangeButtonView)localObject1).setThumbPosition(this.e);
    localObject2 = this.c;
    if ((localObject2 == null) || (((List)localObject2).isEmpty()))
    {
      this.c = new ArrayList();
      this.c.add(BaseApplicationImpl.getApplication().getString(2131888066));
      this.c.add(BaseApplicationImpl.getApplication().getString(2131888067));
      this.c.add(BaseApplicationImpl.getApplication().getString(2131888068));
      this.c.add(BaseApplicationImpl.getApplication().getString(2131888069));
      this.c.add(BaseApplicationImpl.getApplication().getString(2131888070));
    }
    ((RangeButtonView)localObject1).setContentDescList(this.c);
    FontSizePanel.a(localFontSizePanel, this.f);
    return localFontSizePanel;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.FontSizePanel.Builder
 * JD-Core Version:    0.7.0.1
 */