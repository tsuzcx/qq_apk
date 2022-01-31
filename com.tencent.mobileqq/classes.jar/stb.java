import android.content.Context;
import android.content.res.Resources;
import android.text.StaticLayout;
import android.view.View;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.share.RIJShareActionSheetBuilder.2;
import com.tencent.biz.widgets.ElasticHorScrView;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.util.List;

public class stb
  extends ShareActionSheetBuilder
{
  private boolean c;
  
  public stb(Context paramContext)
  {
    super(paramContext);
  }
  
  private void b(View paramView, List<ShareActionSheetBuilder.ActionSheetItem> paramList, StaticLayout paramStaticLayout, int paramInt)
  {
    paramStaticLayout = new std(this.jdField_a_of_type_AndroidContentContext, paramList);
    ElasticHorScrView localElasticHorScrView = (ElasticHorScrView)paramView.findViewById(2131376157);
    LinearLayout localLinearLayout = (LinearLayout)localElasticHorScrView.getChildAt(0);
    localLinearLayout.removeAllViews();
    paramInt = 0;
    if (paramInt < paramList.size())
    {
      View localView = paramStaticLayout.getView(paramInt, null, localLinearLayout);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localView.getLayoutParams();
      label91:
      label125:
      TextView localTextView;
      if (paramInt == 0)
      {
        localLayoutParams.leftMargin = (this.d * 2);
        if (paramInt != paramList.size() - 1) {
          break label235;
        }
        localLayoutParams.rightMargin = (this.h * 2 - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
        localTextView = (TextView)localView.findViewById(2131375510);
        switch (((ShareActionSheetBuilder.ActionSheetItem)paramList.get(paramInt)).action)
        {
        default: 
          localTextView.setVisibility(4);
        }
      }
      for (;;)
      {
        localLinearLayout.addView(localView, localLayoutParams);
        localView.setOnClickListener(new stc(this, paramInt));
        paramInt += 1;
        break;
        localLayoutParams.leftMargin = (this.h * 2 - bcwh.a(this.jdField_a_of_type_AndroidContentContext, 20.0F));
        break label91;
        label235:
        localLayoutParams.rightMargin = 0;
        break label125;
        localTextView.setVisibility(0);
        localTextView.setText(Aladdin.getConfig(273).getString("share_icon_tip_content", localTextView.getResources().getString(2131718990)));
      }
    }
    paramView.post(new RIJShareActionSheetBuilder.2(this, localElasticHorScrView, localLinearLayout));
  }
  
  public int a()
  {
    if (this.c) {
      return 2131562510;
    }
    return 2131558865;
  }
  
  public View a()
  {
    View localView = super.a();
    if (this.c)
    {
      TextView localTextView1 = (TextView)localView.findViewById(2131375515);
      TextView localTextView2 = (TextView)localView.findViewById(2131375512);
      localTextView1.setText(Aladdin.getConfig(273).getString("share_tip_title", localTextView1.getResources().getString(2131718991)));
      localTextView2.setText(Aladdin.getConfig(273).getString("share_tip_desc", localTextView2.getResources().getString(2131718989)));
    }
    return localView;
  }
  
  public void a(View paramView, List<ShareActionSheetBuilder.ActionSheetItem> paramList, StaticLayout paramStaticLayout, int paramInt)
  {
    if (this.c)
    {
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)paramView.findViewById(2131367298));
      b(paramView, paramList, paramStaticLayout, paramInt);
      return;
    }
    super.a(paramView, paramList, paramStaticLayout, paramInt);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }
  
  public void show()
  {
    if (this.c) {
      hideTitle();
    }
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     stb
 * JD-Core Version:    0.7.0.1
 */