import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInJoyDeliverBiuActivity;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.FusionBiuInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.17;

public class qqv
  implements View.OnClickListener
{
  public qqv(ReadInJoyListViewGroup.17 param17) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.b)
    {
      paramView = new Intent(this.a.this$0.a(), ReadInJoyDeliverBiuActivity.class);
      paramView.putExtra("arg_article_info", this.a.a);
      paramView.putExtra("biu_src", 2);
      paramView.putExtra("arg_from_type", 7);
      paramView.putExtra("is_modified_biu", true);
      long l = 0L;
      if (this.a.a.fusionBiuInfo != null) {
        l = this.a.a.fusionBiuInfo.a;
      }
      paramView.putExtra("modified_feeds_id", l);
      paramView.putExtra("should_show_dialog", false);
      this.a.this$0.a().startActivity(paramView);
      this.a.this$0.a().overridePendingTransition(0, 0);
    }
    ReadInJoyListViewGroup.a(this.a.this$0).setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qqv
 * JD-Core Version:    0.7.0.1
 */