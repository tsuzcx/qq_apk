import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.TextData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.BaseItemViewHolder;

public class mlm
  implements View.OnClickListener
{
  public mlm(WebFastAdapter paramWebFastAdapter) {}
  
  public void onClick(View paramView)
  {
    TextData localTextData = (TextData)WebFastAdapter.a(this.a).a;
    ((ClipboardManager)paramView.getContext().getSystemService("clipboard")).setText(localTextData.a.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mlm
 * JD-Core Version:    0.7.0.1
 */