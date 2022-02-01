import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.OnScrollListener;
import com.tencent.avgame.gameroom.gamelist.GameListView;

public class nce
  extends RecyclerView.OnScrollListener
{
  public nce(GameListView paramGameListView) {}
  
  public void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
  {
    if ((paramInt == 1) && (!this.a.c)) {
      this.a.c = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nce
 * JD-Core Version:    0.7.0.1
 */