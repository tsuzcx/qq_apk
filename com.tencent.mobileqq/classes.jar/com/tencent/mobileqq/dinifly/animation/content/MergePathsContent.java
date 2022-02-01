package com.tencent.mobileqq.dinifly.animation.content;

import android.annotation.TargetApi;
import android.graphics.Path;
import android.graphics.Path.Op;
import android.os.Build.VERSION;
import com.tencent.mobileqq.dinifly.model.content.MergePaths;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

@TargetApi(19)
public class MergePathsContent
  implements GreedyContent, PathContent
{
  private final Path firstPath = new Path();
  private final MergePaths mergePaths;
  private final String name;
  private final Path path = new Path();
  private final List<PathContent> pathContents = new ArrayList();
  private final Path remainderPath = new Path();
  
  public MergePathsContent(MergePaths paramMergePaths)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      this.name = paramMergePaths.getName();
      this.mergePaths = paramMergePaths;
      return;
    }
    throw new IllegalStateException("Merge paths are not supported pre-KitKat.");
  }
  
  private void addPaths()
  {
    int i = 0;
    while (i < this.pathContents.size())
    {
      this.path.addPath(((PathContent)this.pathContents.get(i)).getPath());
      i += 1;
    }
  }
  
  @TargetApi(19)
  private void opFirstPathWithRest(Path.Op paramOp)
  {
    this.remainderPath.reset();
    this.firstPath.reset();
    int i = this.pathContents.size() - 1;
    List localList;
    Path localPath;
    while (i >= 1)
    {
      localObject = (PathContent)this.pathContents.get(i);
      if ((localObject instanceof ContentGroup))
      {
        localObject = (ContentGroup)localObject;
        localList = ((ContentGroup)localObject).getPathList();
        int j = localList.size() - 1;
        while (j >= 0)
        {
          localPath = ((PathContent)localList.get(j)).getPath();
          localPath.transform(((ContentGroup)localObject).getTransformationMatrix());
          this.remainderPath.addPath(localPath);
          j -= 1;
        }
      }
      this.remainderPath.addPath(((PathContent)localObject).getPath());
      i -= 1;
    }
    Object localObject = this.pathContents;
    i = 0;
    localObject = (PathContent)((List)localObject).get(0);
    if ((localObject instanceof ContentGroup))
    {
      localObject = (ContentGroup)localObject;
      localList = ((ContentGroup)localObject).getPathList();
      while (i < localList.size())
      {
        localPath = ((PathContent)localList.get(i)).getPath();
        localPath.transform(((ContentGroup)localObject).getTransformationMatrix());
        this.firstPath.addPath(localPath);
        i += 1;
      }
    }
    this.firstPath.set(((PathContent)localObject).getPath());
    this.path.op(this.firstPath, this.remainderPath, paramOp);
  }
  
  public void absorbContent(ListIterator<Content> paramListIterator)
  {
    while ((paramListIterator.hasPrevious()) && (paramListIterator.previous() != this)) {}
    while (paramListIterator.hasPrevious())
    {
      Content localContent = (Content)paramListIterator.previous();
      if ((localContent instanceof PathContent))
      {
        this.pathContents.add((PathContent)localContent);
        paramListIterator.remove();
      }
    }
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public Path getPath()
  {
    this.path.reset();
    if (this.mergePaths.isHidden()) {
      return this.path;
    }
    int i = MergePathsContent.1.$SwitchMap$com$tencent$mobileqq$dinifly$model$content$MergePaths$MergePathsMode[this.mergePaths.getMode().ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4)
          {
            if (i == 5) {
              opFirstPathWithRest(Path.Op.XOR);
            }
          }
          else {
            opFirstPathWithRest(Path.Op.INTERSECT);
          }
        }
        else {
          opFirstPathWithRest(Path.Op.REVERSE_DIFFERENCE);
        }
      }
      else {
        opFirstPathWithRest(Path.Op.UNION);
      }
    }
    else {
      addPaths();
    }
    return this.path;
  }
  
  public void setContents(List<Content> paramList1, List<Content> paramList2)
  {
    int i = 0;
    while (i < this.pathContents.size())
    {
      ((PathContent)this.pathContents.get(i)).setContents(paramList1, paramList2);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.animation.content.MergePathsContent
 * JD-Core Version:    0.7.0.1
 */