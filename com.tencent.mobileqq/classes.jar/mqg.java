import android.widget.BaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.comment.ArticleCommentModule;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ItemDatasListUtils;
import java.util.List;

public class mqg
  implements Runnable
{
  public mqg(FastWebActivity paramFastWebActivity) {}
  
  public void run()
  {
    Object localObject = FastWebActivity.a(this.a).getCommentList();
    ItemDatasListUtils.a(FastWebActivity.a(this.a), (List)localObject, FastWebActivity.a(this.a), FastWebActivity.a(this.a));
    localObject = ReadInJoyLogicEngine.a().a();
    if (localObject != null) {
      ((FastWebModule)localObject).a(FastWebActivity.a(this.a).j, FastWebActivity.a(this.a));
    }
    FastWebActivity.a(this.a).notifyDataSetChanged();
    this.a.a(FastWebActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mqg
 * JD-Core Version:    0.7.0.1
 */