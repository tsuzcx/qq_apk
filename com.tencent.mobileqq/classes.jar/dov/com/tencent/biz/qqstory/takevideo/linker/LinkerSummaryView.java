package dov.com.tencent.biz.qqstory.takevideo.linker;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Handler;
import android.text.Html;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import axqy;
import bjxh;
import bkjr;
import bkjs;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import mzb;
import ved;

public class LinkerSummaryView
  extends FrameLayout
  implements View.OnClickListener, bkjs
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bjxh jdField_a_of_type_Bjxh;
  public bkjr a;
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  public String a;
  boolean jdField_a_of_type_Boolean = false;
  private ImageView jdField_b_of_type_AndroidWidgetImageView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  public String b;
  boolean jdField_b_of_type_Boolean = false;
  private ImageView jdField_c_of_type_AndroidWidgetImageView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  boolean jdField_c_of_type_Boolean = false;
  private TextView d;
  private TextView e;
  
  public LinkerSummaryView(Context paramContext)
  {
    super(paramContext);
    inflate(paramContext, 2131559009, this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131365498));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365499));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365500));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365495));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365494));
    this.d = ((TextView)findViewById(2131365501));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365493));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365497));
    this.e = ((TextView)findViewById(2131365496));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void b()
  {
    Object localObject2;
    if ((this.jdField_a_of_type_Bkjr != null) && (this.jdField_a_of_type_Bkjr.jdField_a_of_type_JavaLangString != null))
    {
      localObject2 = this.jdField_a_of_type_Bkjr.jdField_a_of_type_JavaLangString;
      localObject1 = null;
      int i = ((String)localObject2).lastIndexOf("#");
      if (i > 0) {
        localObject1 = ((String)localObject2).substring(i);
      }
      localObject2 = URLUtil.guessUrl((String)localObject2);
      if (localObject1 == null) {
        break label122;
      }
    }
    label122:
    for (Object localObject1 = (String)localObject2 + (String)localObject1;; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      if (((String)localObject1).lastIndexOf("&_wv=") == -1) {
        localObject2 = mzb.a((String)localObject1, "&_wv=2");
      }
      localObject1 = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserActivity.class);
      ((Intent)localObject1).putExtra("url", (String)localObject2);
      this.jdField_a_of_type_AndroidContentContext.startActivity((Intent)localObject1);
      return;
    }
  }
  
  void a()
  {
    if (this.jdField_c_of_type_Boolean)
    {
      if (this.jdField_b_of_type_JavaLangString != null)
      {
        this.e.setVisibility(0);
        this.e.setText(this.jdField_b_of_type_JavaLangString);
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions;
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable == null) && (this.jdField_a_of_type_JavaLangString != null))
      {
        localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130845729);
        localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130839354);
      }
      try
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
        ved.b(getClass().getName(), "setIconURlDrawable:" + this.jdField_a_of_type_JavaLangString);
        return;
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        localIllegalArgumentException.printStackTrace();
        return;
      }
    }
    this.e.setVisibility(8);
  }
  
  public void a(bkjr parambkjr)
  {
    ThreadManagerV2.getUIHandlerV2().post(new LinkerSummaryView.1(this, parambkjr));
  }
  
  public void a(bkjr parambkjr, int paramInt)
  {
    ThreadManagerV2.getUIHandlerV2().post(new LinkerSummaryView.2(this, parambkjr));
  }
  
  void b(bkjr parambkjr)
  {
    this.jdField_a_of_type_Bkjr = parambkjr;
    String str1 = parambkjr.jdField_a_of_type_JavaLangString;
    String str2 = parambkjr.d;
    str2 = parambkjr.jdField_b_of_type_JavaLangString;
    parambkjr = parambkjr.c;
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839354);
    }
    if (!TextUtils.isEmpty(str2))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
      if (!TextUtils.isEmpty(parambkjr))
      {
        parambkjr = Html.fromHtml(parambkjr);
        ved.b(getClass().getName(), "result:" + parambkjr);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(parambkjr);
      }
      this.d.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    this.d.setVisibility(0);
    this.d.setText(str1);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131365494: 
    case 2131365495: 
    case 2131365496: 
    default: 
    case 2131365493: 
    case 2131365498: 
      do
      {
        return;
        if (this.jdField_a_of_type_Bjxh != null) {
          this.jdField_a_of_type_Bjxh.j();
        }
        this.jdField_a_of_type_Bkjr = null;
        this.jdField_a_of_type_Bjxh = null;
        bjxh.a("clk_linkdelete", this.jdField_a_of_type_AndroidContentContext);
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          b();
          return;
        }
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
      } while (this.jdField_a_of_type_Bjxh == null);
      this.jdField_a_of_type_Bjxh.b(true);
      axqy.b(null, "dc00899", "grp_story", "", "video_edit", "edit_linkbar", 0, 0, "2", "1", "", "");
      return;
      setEditing(true);
      bjxh.a("clk_linkbar", this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    b();
    bjxh.a("clk_linkgo", this.jdField_a_of_type_AndroidContentContext);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Bjxh != null))
    {
      setEditing(false);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEditVideoLinker(bjxh parambjxh)
  {
    this.jdField_a_of_type_Bjxh = parambjxh;
  }
  
  public void setEditing(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
  }
  
  public void setLinkerObject(bkjr parambkjr)
  {
    a();
    if (parambkjr.a())
    {
      b(parambkjr);
      return;
    }
    this.jdField_a_of_type_Bkjr = parambkjr;
    String str = parambkjr.jdField_a_of_type_JavaLangString;
    this.d.setVisibility(0);
    this.d.setText(str);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845729);
    }
    parambkjr.a(this);
    parambkjr.a(str);
  }
  
  public void setReadOnly()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void setShowShare(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.linker.LinkerSummaryView
 * JD-Core Version:    0.7.0.1
 */