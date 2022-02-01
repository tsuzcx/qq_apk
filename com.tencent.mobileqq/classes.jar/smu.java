import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFlowLayout;
import com.tencent.widget.AdapterView.AdapterDataSetObserver;

public class smu
  extends AdapterView.AdapterDataSetObserver
{
  public smu(ReadInJoyFlowLayout paramReadInJoyFlowLayout)
  {
    super(paramReadInJoyFlowLayout);
  }
  
  public void clearSavedState()
  {
    super.clearSavedState();
  }
  
  public void onChanged()
  {
    super.onChanged();
    ReadInJoyFlowLayout.a(this.a);
  }
  
  public void onInvalidated()
  {
    super.onInvalidated();
    ReadInJoyFlowLayout.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     smu
 * JD-Core Version:    0.7.0.1
 */