package com.tencent.mobileqq.search.ftsentity;

import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.fts.v1.FTSEntity;
import com.tencent.mobileqq.search.base.adapter.BaseMvpFaceAdapter;
import com.tencent.mobileqq.search.base.view.IFaceView;
import com.tencent.mobileqq.search.model.IFaceModel;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.widget.AbsListView;
import com.tencent.widget.ListView;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseMvpFTSEntityAdapter<M extends IFaceModel, V extends IFaceView>
  extends BaseMvpFaceAdapter<M, V>
{
  FTSEntitySearchDetailActivity a;
  private int d;
  private int e;
  private int f = 0;
  private List<FTSEntitySearchResultDetailModel> g;
  private List<FTSEntity> h;
  private String i;
  
  public BaseMvpFTSEntityAdapter(ListView paramListView, IFaceDecoder paramIFaceDecoder, List<FTSEntity> paramList, String paramString, FTSEntitySearchDetailActivity paramFTSEntitySearchDetailActivity)
  {
    super(paramListView, paramIFaceDecoder);
    this.h = paramList;
    this.i = paramString;
    this.a = paramFTSEntitySearchDetailActivity;
    this.g = new ArrayList();
  }
  
  private void b()
  {
    if ((this.f - this.e == this.d) && (this.c == 0)) {
      a();
    }
  }
  
  public void a()
  {
    ArrayList localArrayList = SQLiteFTSUtils.b(this.i);
    int k = this.g.size();
    int j = k + 50;
    if (j >= this.h.size()) {
      j = this.h.size();
    }
    while (k < j)
    {
      FTSEntitySearchResultDetailModel localFTSEntitySearchResultDetailModel = FTSEntitySearchUtils.a(this.a.app, this.a.a, this.i, localArrayList, (FTSEntity)this.h.get(k));
      if (localFTSEntitySearchResultDetailModel != null) {
        this.g.add(localFTSEntitySearchResultDetailModel);
      }
      k += 1;
    }
    a(this.g);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.e = paramInt1;
    this.d = paramInt2;
    this.f = paramInt3;
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    super.onScrollStateChanged(paramAbsListView, paramInt);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.ftsentity.BaseMvpFTSEntityAdapter
 * JD-Core Version:    0.7.0.1
 */