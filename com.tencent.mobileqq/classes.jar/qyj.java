import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/pts/data/PTSLiteDataFactory$IPTSLiteDataJson;", "", "addR5ReportJson", "", "articleInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo;", "r5", "Lorg/json/JSONObject;", "updateDataJson", "jsonData", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public abstract interface qyj
{
  public abstract void a(@NotNull ArticleInfo paramArticleInfo, @NotNull JSONObject paramJSONObject);
  
  public abstract void b(@NotNull ArticleInfo paramArticleInfo, @NotNull JSONObject paramJSONObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qyj
 * JD-Core Version:    0.7.0.1
 */