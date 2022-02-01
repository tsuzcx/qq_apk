import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.parse.ProteusParserWithHotReload.IHotReloadChangedObserver;

public class pgf
  implements ProteusParserWithHotReload.IHotReloadChangedObserver
{
  private slt a;
  
  public pgf(slt paramslt)
  {
    this.a = paramslt;
  }
  
  public void a()
  {
    if (ProteusParserWithHotReload.getInstance().isSupportHotReload()) {
      ProteusParserWithHotReload.getInstance().addHotReloadChangedObserver(this);
    }
  }
  
  public void b()
  {
    if (ProteusParserWithHotReload.getInstance().isSupportHotReload()) {
      ProteusParserWithHotReload.getInstance().removeHotReloadChangedObserver(this);
    }
  }
  
  public void onHotReloadChanged(Context paramContext, String paramString1, String paramString2)
  {
    this.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pgf
 * JD-Core Version:    0.7.0.1
 */