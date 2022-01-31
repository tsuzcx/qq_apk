import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Animatable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.subscript.ReadInJoyArticle;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.QQAppInterface;

public class rpw
{
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  public rpu a;
  public View b;
  public ImageView b;
  public TextView b;
  public View c;
  public ImageView c;
  public TextView c;
  public ImageView d;
  
  public rpw(rpv paramrpv, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131309885);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131309886);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131309888));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131309887));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297285));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131297288));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131310892));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131310893));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131300900));
    this.d = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131300901));
    if (!paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramrpv.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131100374));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842545);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new rpx(this, paramrpv));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new rpy(this, paramrpv));
      this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new rpz(this, paramrpv, paramBoolean));
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new rqa(this, paramrpv));
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramrpv.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131100375));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842544);
    }
  }
  
  private void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Rpu.b))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_Rpv.jdField_a_of_type_AndroidAppActivity, PublicAccountBrowser.class);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", this.jdField_a_of_type_Rpu.b);
      localIntent.putExtra("hide_operation_bar", true);
      rtr.a(localIntent, this.jdField_a_of_type_Rpu.b);
      this.jdField_a_of_type_Rpv.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
    }
  }
  
  public void a(int paramInt)
  {
    if ((this.d.isShown()) && ((this.d.getDrawable() instanceof Animatable))) {
      ((Animatable)this.d.getDrawable()).stop();
    }
    switch (paramInt)
    {
    default: 
    case 1: 
    case 2: 
      do
      {
        return;
        if (!this.jdField_a_of_type_Rpv.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842542);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_Rpv.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131100389));
          this.jdField_a_of_type_AndroidWidgetButton.setText(ajjy.a(2131648879));
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          this.d.setVisibility(8);
          return;
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842543);
        }
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.d.setVisibility(0);
      } while (!(this.d.getDrawable() instanceof Animatable));
      ((Animatable)this.d.getDrawable()).start();
      return;
    }
    if (!this.jdField_a_of_type_Rpv.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842545);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_Rpv.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131100388));
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajjy.a(2131648870));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.d.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842544);
    }
  }
  
  public void a(rpu paramrpu, int paramInt)
  {
    if (paramrpu == null) {
      return;
    }
    this.jdField_a_of_type_Rpu = paramrpu;
    if (paramrpu.jdField_a_of_type_Long == -1L)
    {
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    this.jdField_b_of_type_AndroidViewView.setVisibility(0);
    this.jdField_c_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    Object localObject1;
    if (paramrpu.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle != null)
    {
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      rpv.a(this.jdField_a_of_type_Rpv).a(rsl.a(paramrpu.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle.mFirstPagePicUrl, 1, Long.valueOf(paramrpu.jdField_a_of_type_Long)), this.jdField_b_of_type_AndroidWidgetImageView, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height, null, 5);
    }
    label153:
    Object localObject2;
    if (paramrpu.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle != null)
    {
      localObject1 = paramrpu.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle.mTitle.replaceFirst("^\\s+", "");
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Rpv.b) {
        localObject2 = (String)localObject1 + "\n";
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      localObject1 = String.valueOf(paramrpu.jdField_a_of_type_Long);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramrpu.jdField_a_of_type_JavaLangString);
      if (AppSetting.c) {
        this.jdField_a_of_type_AndroidViewView.setContentDescription(paramrpu.jdField_a_of_type_JavaLangString);
      }
      localObject2 = this.jdField_a_of_type_Rpv.jdField_a_of_type_Azwg.a(1, (String)localObject1);
      if (localObject2 != null) {
        break label325;
      }
      this.jdField_a_of_type_Rpv.jdField_a_of_type_Azwg.a((String)localObject1, 1, true);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839687);
    }
    for (;;)
    {
      localObject2 = (ajoy)this.jdField_a_of_type_Rpv.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (localObject2 == null) {
        break;
      }
      if (((ajoy)localObject2).c((String)localObject1) == null) {
        break label337;
      }
      a(1);
      paramrpu.jdField_a_of_type_Int = 1;
      return;
      localObject1 = "";
      break label153;
      label325:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
    }
    label337:
    if (paramrpu.jdField_a_of_type_Int == 2)
    {
      a(2);
      return;
    }
    a(0);
    paramrpu.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rpw
 * JD-Core Version:    0.7.0.1
 */