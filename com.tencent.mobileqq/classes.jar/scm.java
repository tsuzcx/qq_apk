import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class scm
{
  public static final DateFormat a;
  private int jdField_a_of_type_Int = -1;
  private scn jdField_a_of_type_Scn;
  
  static
  {
    jdField_a_of_type_JavaTextDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
  }
  
  public scm()
  {
    a();
  }
  
  private int a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "praseHomeEntraConfig. config is null");
      return -1;
    }
    try
    {
      int i = new JSONObject(paramString).optInt("story_home_show", -1);
      return i;
    }
    catch (JSONException localJSONException)
    {
      urk.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "praseHomeEntraConfig. error config=" + paramString, localJSONException);
    }
    return -1;
  }
  
  private Card a()
  {
    Object localObject = QQStoryContext.a().getCurrentAccountUin();
    localObject = (Card)new QQEntityManagerFactory((String)localObject).createEntityManager().a(Card.class, (String)localObject);
    if (localObject == null) {
      urk.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "get current user birthday failed..");
    }
    return localObject;
  }
  
  private List<sed> a(@NonNull sco paramsco, long paramLong1, long paramLong2)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramsco.e == 1) {}
    for (boolean bool = true;; bool = false)
    {
      vkw.a(bool);
      if (paramsco.jdField_a_of_type_Int == 0) {
        break;
      }
      paramsco = new sed(paramsco, paramsco.jdField_a_of_type_Int);
      urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule rule=%s", new Object[] { paramsco });
      localArrayList.add(paramsco);
      return localArrayList;
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L))
    {
      urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      vkw.a("initFestivalGatherRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      return localArrayList;
    }
    long l;
    if (paramLong1 > paramLong2)
    {
      urk.a("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule endTime=%d, startTime=%d", Long.valueOf(paramLong2), Long.valueOf(paramLong1));
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      int i = Integer.valueOf(vlf.c(1000L * l)).intValue();
      int j = Integer.valueOf(vlf.c(1000L * paramLong2)).intValue();
      while (i <= j)
      {
        sed localsed = new sed(paramsco, i);
        urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule rule=%s", new Object[] { localsed });
        localArrayList.add(localsed);
        i += 1;
      }
      return localArrayList;
      l = paramLong1;
    }
  }
  
  private List<sed> a(@NonNull sco paramsco, long paramLong1, long paramLong2, Card paramCard)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramsco.jdField_b_of_type_Int <= 0) || (TextUtils.isEmpty(paramsco.jdField_b_of_type_JavaLangString)))
    {
      vkw.a("init birthday rule failed:" + paramsco, new Object[0]);
      return localArrayList;
    }
    if ((paramLong1 == 0L) || (paramLong2 == 0L))
    {
      urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initBirthdayRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      vkw.a("initBirthdayRule endTime=%d, startTime=%d", new Object[] { Long.valueOf(paramLong2), Long.valueOf(paramLong1) });
      localArrayList.add(a(paramsco, paramCard, Calendar.getInstance().get(1)));
      return localArrayList;
    }
    long l;
    if (paramLong1 > paramLong2)
    {
      urk.a("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initBirthdayRule endTime=%d, startTime=%d", Long.valueOf(paramLong2), Long.valueOf(paramLong1));
      l = paramLong2;
      paramLong2 = paramLong1;
    }
    for (;;)
    {
      int i = Integer.valueOf(vlf.c(1000L * l)).intValue();
      int j = Integer.valueOf(vlf.c(1000L * paramLong2)).intValue();
      while (i <= j)
      {
        localArrayList.add(a(paramsco, paramCard, i));
        i += 1;
      }
      break;
      l = paramLong1;
    }
  }
  
  private scn a(String paramString)
  {
    boolean bool = true;
    int j = 0;
    if (TextUtils.isEmpty(paramString))
    {
      urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig is null");
      return null;
    }
    Object localObject1;
    Object localObject2;
    label360:
    int i;
    try
    {
      localscn = new scn();
      localObject1 = new JSONObject(paramString);
      if (((JSONObject)localObject1).optInt("album_state", 1) != 1) {
        break label579;
      }
      localscn.jdField_a_of_type_Boolean = bool;
      localscn.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("album_mp4");
      localscn.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("album_cover");
      localscn.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("geohashLevel", 8);
      localObject2 = ((JSONObject)localObject1).optJSONObject("count_limit");
      if (localObject2 != null)
      {
        localscn.jdField_b_of_type_Int = ((JSONObject)localObject2).optInt("first_scan", 500);
        localscn.jdField_c_of_type_Int = ((JSONObject)localObject2).optInt("inc_scan", 100);
        localscn.d = ((JSONObject)localObject2).optInt("first_save", 15);
      }
      if (localscn.jdField_a_of_type_JavaUtilList == null) {
        localscn.jdField_a_of_type_JavaUtilList = new ArrayList();
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("home_rule");
      if (localObject2 != null)
      {
        localObject3 = new scp(2);
        ((scp)localObject3).a((JSONObject)localObject2, 6);
        localscn.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("native_rule");
      if (localObject2 != null)
      {
        localObject3 = new scp(4);
        ((scp)localObject3).a((JSONObject)localObject2, 10);
        localscn.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONObject("foreigner_rule");
      if (localObject2 != null)
      {
        localObject3 = new scp(3);
        ((scp)localObject3).a((JSONObject)localObject2, 10);
        localscn.jdField_a_of_type_JavaUtilList.add(localObject3);
      }
      localObject2 = ((JSONObject)localObject1).optJSONArray("festival_list");
      if ((localObject2 == null) || (((JSONArray)localObject2).length() <= 0)) {
        break label446;
      }
      if (localscn.jdField_b_of_type_JavaUtilList != null) {
        break label567;
      }
      localscn.jdField_b_of_type_JavaUtilList = new ArrayList();
    }
    catch (JSONException localJSONException)
    {
      scn localscn;
      Object localObject3;
      urk.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig error config=" + paramString, localJSONException);
      return null;
    }
    if (i < ((JSONArray)localObject2).length())
    {
      localObject3 = ((JSONArray)localObject2).getJSONObject(i);
      if (localObject3 != null)
      {
        localObject3 = a((JSONObject)localObject3, false);
        if (localObject3 != null)
        {
          localscn.jdField_b_of_type_JavaUtilList.add(localObject3);
          break label572;
          label446:
          urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig do not have festival_list");
        }
      }
    }
    else
    {
      localObject1 = ((JSONObject)localObject1).optJSONArray("mutableFestivalList");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        i = j;
        if (localJSONException.jdField_b_of_type_JavaUtilList == null)
        {
          localJSONException.jdField_b_of_type_JavaUtilList = new ArrayList();
          i = j;
        }
      }
    }
    for (;;)
    {
      if (i < ((JSONArray)localObject1).length())
      {
        localObject2 = ((JSONArray)localObject1).getJSONObject(i);
        if (localObject2 != null)
        {
          localObject2 = a((JSONObject)localObject2, true);
          if (localObject2 != null)
          {
            localJSONException.jdField_b_of_type_JavaUtilList.add(localObject2);
            break label585;
            urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "parseAlbumConfig do not have mutableFestivalList");
          }
        }
      }
      else
      {
        return localJSONException;
        label567:
        i = 0;
        break label360;
        label572:
        i += 1;
        break label360;
        label579:
        bool = false;
        break;
      }
      label585:
      i += 1;
    }
  }
  
  private sco a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    int i = 1;
    if (paramJSONObject.optInt("type", 1) == 2) {
      i = 6;
    }
    sco localsco = new sco(i);
    localsco.a(paramJSONObject, 6);
    localsco.jdField_a_of_type_JavaLangString = paramJSONObject.optString("name", "");
    localsco.jdField_c_of_type_Int = paramJSONObject.optInt("start_age", -2147483648);
    localsco.d = paramJSONObject.optInt("end_age", -2147483648);
    if ((localsco.jdField_c_of_type_Int == -2147483648) || (localsco.d == -2147483648))
    {
      urk.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "festival_list error: has no age. config=" + paramJSONObject);
      return null;
    }
    if (localsco.e == 6)
    {
      paramJSONObject = paramJSONObject.optJSONObject("time");
      if (paramJSONObject != null)
      {
        localsco.jdField_b_of_type_JavaLangString = paramJSONObject.optString("start", "");
        localsco.jdField_b_of_type_Int = paramJSONObject.optInt("duration", 24);
      }
    }
    for (;;)
    {
      return localsco;
      localsco.jdField_a_of_type_Int = paramJSONObject.optInt("year", 0);
      if ((localsco.jdField_a_of_type_Int == 0) && (paramBoolean))
      {
        urk.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "festival_list error: has no year. config=" + paramJSONObject);
        return null;
      }
      paramJSONObject = paramJSONObject.optJSONObject("time");
      if (paramJSONObject != null)
      {
        localsco.jdField_b_of_type_JavaLangString = paramJSONObject.optString("start", "");
        localsco.jdField_c_of_type_JavaLangString = paramJSONObject.optString("end", "");
      }
    }
  }
  
  private sed a(@NonNull sco paramsco, Card paramCard, int paramInt)
  {
    paramsco = new sed(paramsco, paramCard, paramInt);
    urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initFestivalGatherRule year=%d, rule=%s", new Object[] { Integer.valueOf(paramInt), paramsco });
    return paramsco;
  }
  
  private see a(@NonNull scp paramscp)
  {
    paramscp = new see(paramscp);
    urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "initTreeGatherRule rule=%s", new Object[] { paramscp });
    return paramscp;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Scn != null) {
      return this.jdField_a_of_type_Scn.d;
    }
    return 0;
  }
  
  public int a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Scn != null)
    {
      if (paramBoolean) {
        return this.jdField_a_of_type_Scn.jdField_c_of_type_Int;
      }
      return this.jdField_a_of_type_Scn.jdField_b_of_type_Int;
    }
    return 0;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_Scn != null) {
      return this.jdField_a_of_type_Scn.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public List<see> a()
  {
    if ((this.jdField_a_of_type_Scn == null) || (this.jdField_a_of_type_Scn.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Scn.jdField_a_of_type_JavaUtilList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_Scn.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      localArrayList.add(a((scp)localIterator.next()));
    }
    return localArrayList;
  }
  
  public List<scz> a(long paramLong1, long paramLong2)
  {
    if ((this.jdField_a_of_type_Scn == null) || (this.jdField_a_of_type_Scn.jdField_b_of_type_JavaUtilList == null) || (this.jdField_a_of_type_Scn.jdField_b_of_type_JavaUtilList.isEmpty())) {
      return null;
    }
    Card localCard = a();
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    if (localCard == null)
    {
      localObject1 = "card is null";
      urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList startTime=%s age=%d", new Object[] { Long.valueOf(paramLong1), localObject1 });
      localObject1 = this.jdField_a_of_type_Scn.jdField_b_of_type_JavaUtilList.iterator();
    }
    for (;;)
    {
      if (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (sco)((Iterator)localObject1).next();
        if ((((sco)localObject2).jdField_c_of_type_Int >= 0) && ((localCard == null) || (localCard.age < ((sco)localObject2).jdField_c_of_type_Int)))
        {
          urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "you are too young. config=%s", new Object[] { localObject2 });
          continue;
          localObject1 = Byte.valueOf(localCard.age);
          break;
        }
        if ((((sco)localObject2).d >= 0) && ((localCard == null) || (localCard.age > ((sco)localObject2).d)))
        {
          urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "it's not suitable for you. config=%s", new Object[] { localObject2 });
          continue;
        }
        switch (((sco)localObject2).e)
        {
        default: 
          break;
        case 1: 
          try
          {
            localObject2 = a((sco)localObject2, paramLong1, paramLong2);
            if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
            {
              localObject2 = ((List)localObject2).iterator();
              while (((Iterator)localObject2).hasNext()) {
                localArrayList.add(new sdc((sed)((Iterator)localObject2).next()));
              }
            }
          }
          catch (ParseException localParseException1)
          {
            urk.e("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList config=%s", new Object[] { this.jdField_a_of_type_Scn, localParseException1 });
          }
        case 6: 
          try
          {
            Iterator localIterator = a(localParseException1, paramLong1, paramLong2, localCard).iterator();
            while (localIterator.hasNext())
            {
              sed localsed = (sed)localIterator.next();
              if ((localsed.a > 0L) && (localsed.b > 0L)) {
                localArrayList.add(0, new sdc(localsed));
              }
            }
          }
          catch (ParseException localParseException2)
          {
            urk.c("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "getFestivalFilterList BirthdayAlbumFilter:%s", localParseException2);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public void a()
  {
    String str2 = spz.f();
    if (!TextUtils.isEmpty(str2)) {
      this.jdField_a_of_type_Scn = a(str2);
    }
    String str3 = spz.g();
    this.jdField_a_of_type_Int = a(str3);
    String str1 = str3;
    if (str3 == null) {
      str1 = "";
    }
    if (str2 == null) {
      str2 = "";
    }
    for (;;)
    {
      urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.loadConfig homeEntraConfig=%s config=%s ", new Object[] { str1, str2 });
      return;
    }
  }
  
  public boolean a()
  {
    urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.isConfigEnable config=%s", new Object[] { this.jdField_a_of_type_Scn });
    return this.jdField_a_of_type_Scn != null;
  }
  
  public boolean a(String paramString)
  {
    scn localscn = a(paramString);
    if (localscn != null)
    {
      urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleAlbumConfig old config=%s, new config=%s", new Object[] { this.jdField_a_of_type_Scn, paramString });
      spz.h(paramString);
      this.jdField_a_of_type_Scn = localscn;
      return true;
    }
    return false;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_Scn != null) {
      return this.jdField_a_of_type_Scn.jdField_a_of_type_Int;
    }
    return 8;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_Scn != null) {
      return this.jdField_a_of_type_Scn.jdField_b_of_type_JavaLangString;
    }
    return null;
  }
  
  public void b()
  {
    urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.clearAlbumConfig");
    spz.h("");
    this.jdField_a_of_type_Scn = null;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Scn != null) {
      return this.jdField_a_of_type_Scn.jdField_a_of_type_Boolean;
    }
    return true;
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "StoryHomeAlbumEntraConfig is null");
    }
    do
    {
      return false;
      urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleStoryHomeAlbumEntraConfig old config=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      this.jdField_a_of_type_Int = a(paramString);
      urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.handleStoryHomeAlbumEntraConfig new config=%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    } while (this.jdField_a_of_type_Int == -1);
    spz.i(paramString);
    return true;
  }
  
  public void c()
  {
    urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager.clearStoryHomeAlbumEntraConfig");
    spz.i("");
    this.jdField_a_of_type_Int = -1;
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Scn != null)
    {
      urk.d("Q.qqstory.recommendAlbum.logic.StoryAlbumConfig", "configManager mStoryHomeAlbumEntraState=%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
      return this.jdField_a_of_type_Int != 0;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     scm
 * JD-Core Version:    0.7.0.1
 */