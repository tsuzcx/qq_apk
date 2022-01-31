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

public class sue
{
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  public suc a;
  public View b;
  public ImageView b;
  public TextView b;
  public View c;
  public ImageView c;
  public TextView c;
  public ImageView d;
  
  public sue(sud paramsud, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376138);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131376139);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376141));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376140));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362857));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362860));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377211));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131377212));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366617));
    this.d = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366618));
    if (!paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramsud.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166003));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842812);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new suf(this, paramsud));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new sug(this, paramsud));
      this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new suh(this, paramsud, paramBoolean));
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new sui(this, paramsud));
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramsud.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166004));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842811);
    }
  }
  
  private void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Suc.b))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_Sud.jdField_a_of_type_AndroidAppActivity, PublicAccountBrowser.class);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", this.jdField_a_of_type_Suc.b);
      localIntent.putExtra("hide_operation_bar", true);
      syb.a(localIntent, this.jdField_a_of_type_Suc.b);
      this.jdField_a_of_type_Sud.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
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
        if (!this.jdField_a_of_type_Sud.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842809);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_Sud.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166018));
          this.jdField_a_of_type_AndroidWidgetButton.setText(alpo.a(2131715051));
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          this.d.setVisibility(8);
          return;
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842810);
        }
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.d.setVisibility(0);
      } while (!(this.d.getDrawable() instanceof Animatable));
      ((Animatable)this.d.getDrawable()).start();
      return;
    }
    if (!this.jdField_a_of_type_Sud.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842812);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_Sud.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131166017));
      this.jdField_a_of_type_AndroidWidgetButton.setText(alpo.a(2131715042));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.d.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842811);
    }
  }
  
  public void a(suc paramsuc, int paramInt)
  {
    if (paramsuc == null) {
      return;
    }
    this.jdField_a_of_type_Suc = paramsuc;
    if (paramsuc.jdField_a_of_type_Long == -1L)
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
    if (paramsuc.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle != null)
    {
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      sud.a(this.jdField_a_of_type_Sud).a(swu.a(paramsuc.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle.mFirstPagePicUrl, 1, Long.valueOf(paramsuc.jdField_a_of_type_Long)), this.jdField_b_of_type_AndroidWidgetImageView, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height, null, 5);
    }
    label153:
    Object localObject2;
    if (paramsuc.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle != null)
    {
      localObject1 = paramsuc.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle.mTitle.replaceFirst("^\\s+", "");
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Sud.b) {
        localObject2 = (String)localObject1 + "\n";
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      localObject1 = String.valueOf(paramsuc.jdField_a_of_type_Long);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramsuc.jdField_a_of_type_JavaLangString);
      if (AppSetting.c) {
        this.jdField_a_of_type_AndroidViewView.setContentDescription(paramsuc.jdField_a_of_type_JavaLangString);
      }
      localObject2 = this.jdField_a_of_type_Sud.jdField_a_of_type_Bcws.a(1, (String)localObject1);
      if (localObject2 != null) {
        break label325;
      }
      this.jdField_a_of_type_Sud.jdField_a_of_type_Bcws.a((String)localObject1, 1, true);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130840084);
    }
    for (;;)
    {
      localObject2 = (aluw)this.jdField_a_of_type_Sud.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (localObject2 == null) {
        break;
      }
      if (((aluw)localObject2).c((String)localObject1) == null) {
        break label337;
      }
      a(1);
      paramsuc.jdField_a_of_type_Int = 1;
      return;
      localObject1 = "";
      break label153;
      label325:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
    }
    label337:
    if (paramsuc.jdField_a_of_type_Int == 2)
    {
      a(2);
      return;
    }
    a(0);
    paramsuc.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     sue
 * JD-Core Version:    0.7.0.1
 */