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

public class sco
{
  public View a;
  public Button a;
  public ImageView a;
  public TextView a;
  public scm a;
  public View b;
  public ImageView b;
  public TextView b;
  public View c;
  public ImageView c;
  public TextView c;
  public ImageView d;
  
  public sco(scn paramscn, View paramView, boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_b_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131375644);
    this.jdField_c_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewView.findViewById(2131375645);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375647));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131375646));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362825));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131362828));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376699));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376700));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131366509));
    this.d = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131366510));
    if (!paramBoolean)
    {
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramscn.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165964));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842628);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new scp(this, paramscn));
      this.jdField_a_of_type_AndroidViewView.setOnClickListener(new scq(this, paramscn));
      this.jdField_c_of_type_AndroidViewView.setOnTouchListener(new scr(this, paramscn, paramBoolean));
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(new scs(this, paramscn));
      return;
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(paramscn.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165965));
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842627);
    }
  }
  
  private void a()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_Scm.b))
    {
      Intent localIntent = new Intent(this.jdField_a_of_type_Scn.jdField_a_of_type_AndroidAppActivity, PublicAccountBrowser.class);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", this.jdField_a_of_type_Scm.b);
      localIntent.putExtra("hide_operation_bar", true);
      sgj.a(localIntent, this.jdField_a_of_type_Scm.b);
      this.jdField_a_of_type_Scn.jdField_a_of_type_AndroidAppActivity.startActivity(localIntent);
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
        if (!this.jdField_a_of_type_Scn.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842625);
        }
        for (;;)
        {
          this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_Scn.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165979));
          this.jdField_a_of_type_AndroidWidgetButton.setText(ajyc.a(2131714668));
          this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
          this.d.setVisibility(8);
          return;
          this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842626);
        }
        this.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
        this.d.setVisibility(0);
      } while (!(this.d.getDrawable() instanceof Animatable));
      ((Animatable)this.d.getDrawable()).start();
      return;
    }
    if (!this.jdField_a_of_type_Scn.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842628);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetButton.setTextColor(this.jdField_a_of_type_Scn.jdField_a_of_type_AndroidAppActivity.getResources().getColor(2131165978));
      this.jdField_a_of_type_AndroidWidgetButton.setText(ajyc.a(2131714659));
      this.jdField_a_of_type_AndroidWidgetButton.setVisibility(0);
      this.d.setVisibility(8);
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setBackgroundResource(2130842627);
    }
  }
  
  public void a(scm paramscm, int paramInt)
  {
    if (paramscm == null) {
      return;
    }
    this.jdField_a_of_type_Scm = paramscm;
    if (paramscm.jdField_a_of_type_Long == -1L)
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
    if (paramscm.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle != null)
    {
      localObject1 = this.jdField_b_of_type_AndroidWidgetImageView.getLayoutParams();
      scn.a(this.jdField_a_of_type_Scn).a(sfd.a(paramscm.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle.mFirstPagePicUrl, 1, Long.valueOf(paramscm.jdField_a_of_type_Long)), this.jdField_b_of_type_AndroidWidgetImageView, ((ViewGroup.LayoutParams)localObject1).width, ((ViewGroup.LayoutParams)localObject1).height, null, 5);
    }
    label153:
    Object localObject2;
    if (paramscm.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle != null)
    {
      localObject1 = paramscm.jdField_a_of_type_ComTencentBizPubaccountSubscriptReadInJoyArticle.mTitle.replaceFirst("^\\s+", "");
      localObject2 = localObject1;
      if (this.jdField_a_of_type_Scn.b) {
        localObject2 = (String)localObject1 + "\n";
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      localObject1 = String.valueOf(paramscm.jdField_a_of_type_Long);
      this.jdField_c_of_type_AndroidWidgetTextView.setText(paramscm.jdField_a_of_type_JavaLangString);
      if (AppSetting.d) {
        this.jdField_a_of_type_AndroidViewView.setContentDescription(paramscm.jdField_a_of_type_JavaLangString);
      }
      localObject2 = this.jdField_a_of_type_Scn.jdField_a_of_type_Baxk.a(1, (String)localObject1);
      if (localObject2 != null) {
        break label325;
      }
      this.jdField_a_of_type_Scn.jdField_a_of_type_Baxk.a((String)localObject1, 1, true);
      this.jdField_c_of_type_AndroidWidgetImageView.setImageResource(2130839736);
    }
    for (;;)
    {
      localObject2 = (akdi)this.jdField_a_of_type_Scn.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(56);
      if (localObject2 == null) {
        break;
      }
      if (((akdi)localObject2).c((String)localObject1) == null) {
        break label337;
      }
      a(1);
      paramscm.jdField_a_of_type_Int = 1;
      return;
      localObject1 = "";
      break label153;
      label325:
      this.jdField_c_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject2);
    }
    label337:
    if (paramscm.jdField_a_of_type_Int == 2)
    {
      a(2);
      return;
    }
    a(0);
    paramscm.jdField_a_of_type_Int = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     sco
 * JD-Core Version:    0.7.0.1
 */