package com.tencent.mobileqq.qqlive.prepare;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class GameListAdapter
  extends RecyclerView.Adapter<GameListAdapter.GameItemViewHolder>
{
  public static final DownloadParams.DecodeHandler a = new GameListAdapter.2();
  private Context b;
  private final URLDrawable.URLDrawableOptions c = URLDrawable.URLDrawableOptions.obtain();
  private final int d = ViewUtils.dip2px(60.0F);
  private List<GameItem> e = new ArrayList();
  private GameListAdapter.OnListItemReactListener f;
  
  public GameListAdapter(Context paramContext)
  {
    this.b = paramContext;
    paramContext = this.c;
    int i = this.d;
    paramContext.mRequestWidth = i;
    paramContext.mRequestHeight = i;
  }
  
  private void a(GameItem paramGameItem, GameListAdapter.GameItemViewHolder paramGameItemViewHolder)
  {
    try
    {
      this.c.mFailedDrawable = this.b.getResources().getDrawable(2130848131);
      paramGameItem = URLDrawable.getDrawable(paramGameItem.c(), this.c);
      paramGameItem.setTag(new int[] { this.d, this.d });
      paramGameItem.setDecodeHandler(a);
      GameListAdapter.GameItemViewHolder.b(paramGameItemViewHolder).setImageDrawable(paramGameItem);
      return;
    }
    catch (Exception paramGameItem)
    {
      QLog.e("GameListAdapter", 1, paramGameItem, new Object[0]);
    }
  }
  
  public GameListAdapter.GameItemViewHolder a(@NonNull ViewGroup paramViewGroup, int paramInt)
  {
    return new GameListAdapter.GameItemViewHolder(LayoutInflater.from(this.b).inflate(2131627988, null));
  }
  
  public void a(@NonNull GameListAdapter.GameItemViewHolder paramGameItemViewHolder, int paramInt)
  {
    if ((paramGameItemViewHolder != null) && (paramInt < this.e.size()))
    {
      GameItem localGameItem = (GameItem)this.e.get(paramInt);
      paramGameItemViewHolder.itemView.setOnClickListener(new GameListAdapter.1(this, localGameItem, paramInt));
      GameListAdapter.OnListItemReactListener localOnListItemReactListener = this.f;
      if (localOnListItemReactListener != null) {
        localOnListItemReactListener.a(paramGameItemViewHolder, localGameItem, paramInt);
      }
      a(localGameItem, paramGameItemViewHolder);
      GameListAdapter.GameItemViewHolder.a(paramGameItemViewHolder).setText(localGameItem.b());
    }
  }
  
  public void a(GameListAdapter.OnListItemReactListener paramOnListItemReactListener)
  {
    this.f = paramOnListItemReactListener;
  }
  
  public void a(List<GameItem> paramList)
  {
    this.e = paramList;
  }
  
  public int getItemCount()
  {
    return this.e.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.GameListAdapter
 * JD-Core Version:    0.7.0.1
 */