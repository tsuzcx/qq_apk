package dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle;

import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.BaseLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.base.DoodleStrategy;
import java.util.ArrayList;
import java.util.List;

public class DoodleLayout$NormalDoodleStategy
  implements DoodleStrategy
{
  ArrayList a = null;
  
  public DoodleLayout$NormalDoodleStategy(BaseLayer... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length <= 0)) {
      throw new IllegalArgumentException("layers should not be null or empty");
    }
    this.a = new ArrayList(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      BaseLayer localBaseLayer = paramVarArgs[i];
      if (localBaseLayer != null) {
        this.a.add(localBaseLayer);
      }
      i += 1;
    }
  }
  
  public BaseLayer a(String paramString)
  {
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      if (((BaseLayer)this.a.get(i)).a().equals(paramString)) {
        return (BaseLayer)this.a.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public void a(List paramList, DoodleView paramDoodleView)
  {
    paramList.addAll(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.NormalDoodleStategy
 * JD-Core Version:    0.7.0.1
 */