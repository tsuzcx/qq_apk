import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ArrayAdapter;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

public class qqt
  extends ArrayAdapter<TagInfo>
{
  final Set<TagInfo> a = new LinkedHashSet();
  
  public qqt(@NonNull Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public void a(@Nullable TagInfo paramTagInfo)
  {
    if (!this.a.contains(paramTagInfo))
    {
      this.a.add(paramTagInfo);
      super.add(paramTagInfo);
    }
  }
  
  public void a(TagInfo... paramVarArgs)
  {
    addAll(Arrays.asList(paramVarArgs));
  }
  
  public void addAll(@NonNull Collection<? extends TagInfo> paramCollection)
  {
    paramCollection = new LinkedHashSet(paramCollection);
    paramCollection.removeAll(this.a);
    this.a.addAll(paramCollection);
    super.addAll(paramCollection);
  }
  
  public void b(@Nullable TagInfo paramTagInfo)
  {
    this.a.remove(paramTagInfo);
    super.remove(paramTagInfo);
  }
  
  public void clear()
  {
    super.clear();
    this.a.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     qqt
 * JD-Core Version:    0.7.0.1
 */