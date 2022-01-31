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
import axqw;
import bjwq;
import bkja;
import bkjb;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import mze;
import veg;

public class LinkerSummaryView
  extends FrameLayout
  implements View.OnClickListener, bkjb
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bjwq jdField_a_of_type_Bjwq;
  public bkja a;
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
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131365499));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365500));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365501));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365496));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131365495));
    this.d = ((TextView)findViewById(2131365502));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365494));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131365498));
    this.e = ((TextView)findViewById(2131365497));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void b()
  {
    Object localObject2;
    if ((this.jdField_a_of_type_Bkja != null) && (this.jdField_a_of_type_Bkja.jdField_a_of_type_JavaLangString != null))
    {
      localObject2 = this.jdField_a_of_type_Bkja.jdField_a_of_type_JavaLangString;
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
        localObject2 = mze.a((String)localObject1, "&_wv=2");
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
        localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130845723);
        localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130839354);
      }
      try
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
        veg.b(getClass().getName(), "setIconURlDrawable:" + this.jdField_a_of_type_JavaLangString);
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
  
  public void a(bkja parambkja)
  {
    ThreadManagerV2.getUIHandlerV2().post(new LinkerSummaryView.1(this, parambkja));
  }
  
  public void a(bkja parambkja, int paramInt)
  {
    ThreadManagerV2.getUIHandlerV2().post(new LinkerSummaryView.2(this, parambkja));
  }
  
  void b(bkja parambkja)
  {
    this.jdField_a_of_type_Bkja = parambkja;
    String str1 = parambkja.jdField_a_of_type_JavaLangString;
    String str2 = parambkja.d;
    str2 = parambkja.jdField_b_of_type_JavaLangString;
    parambkja = parambkja.c;
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839354);
    }
    if (!TextUtils.isEmpty(str2))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
      if (!TextUtils.isEmpty(parambkja))
      {
        parambkja = Html.fromHtml(parambkja);
        veg.b(getClass().getName(), "result:" + parambkja);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(parambkja);
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
    case 2131365495: 
    case 2131365496: 
    case 2131365497: 
    default: 
    case 2131365494: 
    case 2131365499: 
      do
      {
        return;
        if (this.jdField_a_of_type_Bjwq != null) {
          this.jdField_a_of_type_Bjwq.j();
        }
        this.jdField_a_of_type_Bkja = null;
        this.jdField_a_of_type_Bjwq = null;
        bjwq.a("clk_linkdelete", this.jdField_a_of_type_AndroidContentContext);
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          b();
          return;
        }
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
      } while (this.jdField_a_of_type_Bjwq == null);
      this.jdField_a_of_type_Bjwq.b(true);
      axqw.b(null, "dc00899", "grp_story", "", "video_edit", "edit_linkbar", 0, 0, "2", "1", "", "");
      return;
      setEditing(true);
      bjwq.a("clk_linkbar", this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    b();
    bjwq.a("clk_linkgo", this.jdField_a_of_type_AndroidContentContext);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Bjwq != null))
    {
      setEditing(false);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEditVideoLinker(bjwq parambjwq)
  {
    this.jdField_a_of_type_Bjwq = parambjwq;
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
  
  public void setLinkerObject(bkja parambkja)
  {
    a();
    if (parambkja.a())
    {
      b(parambkja);
      return;
    }
    this.jdField_a_of_type_Bkja = parambkja;
    String str = parambkja.jdField_a_of_type_JavaLangString;
    this.d.setVisibility(0);
    this.d.setText(str);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845723);
    }
    parambkja.a(this);
    parambkja.a(str);
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