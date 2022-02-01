import java.util.List;

public abstract interface pxh<BEAN>
{
  public abstract void setCenterEmpty();
  
  public abstract void setCenterError(int paramInt, String paramString);
  
  public abstract void setCenterHide();
  
  public abstract void setCenterLoading();
  
  public abstract void setFooterError(int paramInt, String paramString);
  
  public abstract void setFooterHasMore();
  
  public abstract void setFooterHide();
  
  public abstract void setFooterLoading();
  
  public abstract void setFooterNoMore();
  
  public abstract void setHeaderError(int paramInt, String paramString);
  
  public abstract void setHeaderLoading();
  
  public abstract void setHeaderSuccess();
  
  public abstract void setListData(List<BEAN> paramList, boolean paramBoolean);
  
  public abstract void setTotal(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pxh
 * JD-Core Version:    0.7.0.1
 */