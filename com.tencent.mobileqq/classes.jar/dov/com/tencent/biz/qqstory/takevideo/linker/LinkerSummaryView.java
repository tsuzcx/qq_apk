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
import awqx;
import bifv;
import bism;
import bisn;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import mof;
import urk;

public class LinkerSummaryView
  extends FrameLayout
  implements View.OnClickListener, bisn
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  bifv jdField_a_of_type_Bifv;
  public bism a;
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
    inflate(paramContext, 2131493446, this);
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)findViewById(2131299919));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299920));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299921));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299916));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131299915));
    this.d = ((TextView)findViewById(2131299922));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299914));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131299918));
    this.e = ((TextView)findViewById(2131299917));
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void b()
  {
    Object localObject2;
    if ((this.jdField_a_of_type_Bism != null) && (this.jdField_a_of_type_Bism.jdField_a_of_type_JavaLangString != null))
    {
      localObject2 = this.jdField_a_of_type_Bism.jdField_a_of_type_JavaLangString;
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
        localObject2 = mof.a((String)localObject1, "&_wv=2");
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
        localURLDrawableOptions.mLoadingDrawable = getResources().getDrawable(2130845540);
        localURLDrawableOptions.mFailedDrawable = getResources().getDrawable(2130839330);
      }
      try
      {
        this.jdField_a_of_type_ComTencentImageURLDrawable = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentImageURLDrawable);
        urk.b(getClass().getName(), "setIconURlDrawable:" + this.jdField_a_of_type_JavaLangString);
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
  
  public void a(bism parambism)
  {
    ThreadManagerV2.getUIHandlerV2().post(new LinkerSummaryView.1(this, parambism));
  }
  
  public void a(bism parambism, int paramInt)
  {
    ThreadManagerV2.getUIHandlerV2().post(new LinkerSummaryView.2(this, parambism));
  }
  
  void b(bism parambism)
  {
    this.jdField_a_of_type_Bism = parambism;
    String str1 = parambism.jdField_a_of_type_JavaLangString;
    String str2 = parambism.d;
    str2 = parambism.jdField_b_of_type_JavaLangString;
    parambism = parambism.c;
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839330);
    }
    if (!TextUtils.isEmpty(str2))
    {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
      if (!TextUtils.isEmpty(parambism))
      {
        parambism = Html.fromHtml(parambism);
        urk.b(getClass().getName(), "result:" + parambism);
        this.jdField_c_of_type_AndroidWidgetTextView.setText(parambism);
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
    case 2131299915: 
    case 2131299916: 
    case 2131299917: 
    default: 
    case 2131299914: 
    case 2131299919: 
      do
      {
        return;
        if (this.jdField_a_of_type_Bifv != null) {
          this.jdField_a_of_type_Bifv.j();
        }
        this.jdField_a_of_type_Bism = null;
        this.jdField_a_of_type_Bifv = null;
        bifv.a("clk_linkdelete", this.jdField_a_of_type_AndroidContentContext);
        return;
        if (this.jdField_a_of_type_Boolean)
        {
          b();
          return;
        }
        if (!this.jdField_b_of_type_Boolean) {
          break;
        }
      } while (this.jdField_a_of_type_Bifv == null);
      this.jdField_a_of_type_Bifv.b(true);
      awqx.b(null, "dc00899", "grp_story", "", "video_edit", "edit_linkbar", 0, 0, "2", "1", "", "");
      return;
      setEditing(true);
      bifv.a("clk_linkbar", this.jdField_a_of_type_AndroidContentContext);
      return;
    }
    b();
    bifv.a("clk_linkgo", this.jdField_a_of_type_AndroidContentContext);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((!this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_Bifv != null))
    {
      setEditing(false);
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setEditVideoLinker(bifv parambifv)
  {
    this.jdField_a_of_type_Bifv = parambifv;
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
  
  public void setLinkerObject(bism parambism)
  {
    a();
    if (parambism.a())
    {
      b(parambism);
      return;
    }
    this.jdField_a_of_type_Bism = parambism;
    String str = parambism.jdField_a_of_type_JavaLangString;
    this.d.setVisibility(0);
    this.d.setText(str);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_c_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    if (!this.jdField_c_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130845540);
    }
    parambism.a(this);
    parambism.a(str);
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