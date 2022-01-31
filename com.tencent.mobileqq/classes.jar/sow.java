import android.database.Cursor;
import com.tencent.biz.qqstory.database.CardEntry;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.database.DiscoverBannerVideoEntry;
import com.tencent.biz.qqstory.database.DownloadingUrlEntry;
import com.tencent.biz.qqstory.database.FeedEntry;
import com.tencent.biz.qqstory.database.HotTopicEntry;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.database.LiveVideoEntry;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.database.MsgTabNodeEntity;
import com.tencent.biz.qqstory.database.OfficialRecommendEntry;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.database.ReportWatchVideoEntry;
import com.tencent.biz.qqstory.database.ShareGroupListEntry;
import com.tencent.biz.qqstory.database.StoryAlbumEntry;
import com.tencent.biz.qqstory.database.StoryAlbumPicEntry;
import com.tencent.biz.qqstory.database.StoryEntry;
import com.tencent.biz.qqstory.database.StoryVideoEntry;
import com.tencent.biz.qqstory.database.StoryVideoListEntry;
import com.tencent.biz.qqstory.database.StoryVideoSimpleInfoEntity;
import com.tencent.biz.qqstory.database.TopicInfoEntry;
import com.tencent.biz.qqstory.database.TroopStoryEntry;
import com.tencent.biz.qqstory.database.UnionIdMapEntity;
import com.tencent.biz.qqstory.database.UserEntry;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabHaloEntity;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeRecommendActivityReadEntity;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeVidListEntity;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QQEntityManagerFactory.SQLiteOpenHelperImpl;
import com.tencent.mobileqq.utils.SecurityUtile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class sow
  extends QQEntityManagerFactory
{
  public sow(String paramString)
  {
    super(paramString);
  }
  
  public static void a(String paramString, android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    long l = System.currentTimeMillis();
    Cursor localCursor1 = paramSQLiteDatabase.rawQuery("select distinct tbl_name from Sqlite_master", null);
    ArrayList localArrayList = new ArrayList();
    if (localCursor1 != null)
    {
      while (localCursor1.moveToNext())
      {
        String str = SecurityUtile.b(localCursor1.getString(0));
        Cursor localCursor2 = paramSQLiteDatabase.rawQuery("select sql from sqlite_master where type=? and name=?", new String[] { "table", str });
        if (localCursor2 != null) {
          for (;;)
          {
            try
            {
              if (!str.equals(UserEntry.class.getSimpleName())) {
                continue;
              }
              localObject = UserEntry.class;
              atnc.a(localArrayList, str, localCursor2, (Class)localObject);
            }
            catch (ClassNotFoundException localClassNotFoundException)
            {
              Object localObject;
              urk.b("Q.qqstory.QQStoryEntityManagerFactory", "checkColumnChange", localClassNotFoundException);
              continue;
            }
            localCursor2.close();
            break;
            if (str.equals(StoryEntry.class.getSimpleName())) {
              localObject = StoryEntry.class;
            } else if (str.equals(StoryVideoEntry.class.getSimpleName())) {
              localObject = StoryVideoEntry.class;
            } else if (str.equals(StoryVideoListEntry.class.getSimpleName())) {
              localObject = StoryVideoListEntry.class;
            } else if (str.startsWith(PublishVideoEntry.class.getSimpleName())) {
              localObject = PublishVideoEntry.class;
            } else if (str.equals(HotTopicEntry.class.getSimpleName())) {
              localObject = HotTopicEntry.class;
            } else {
              localObject = Class.forName(paramString + "." + str);
            }
          }
        }
      }
      localCursor1.close();
    }
    com.tencent.mobileqq.app.SQLiteDatabase.beginTransactionLog();
    paramSQLiteDatabase.beginTransaction();
    try
    {
      paramString = localArrayList.iterator();
      while (paramString.hasNext()) {
        paramSQLiteDatabase.execSQL((String)paramString.next());
      }
      paramSQLiteDatabase.setTransactionSuccessful();
    }
    finally
    {
      paramSQLiteDatabase.endTransaction();
      com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
    }
    paramSQLiteDatabase.endTransaction();
    com.tencent.mobileqq.app.SQLiteDatabase.endTransactionLog();
    urk.a("Q.qqstory.QQStoryEntityManagerFactory", "checkColumnChange take time:%d", Long.valueOf(System.currentTimeMillis() - l));
  }
  
  public void a()
  {
    a(this.mInnerDbHelper.getWritableDatabase());
    createDatabase(this.mInnerDbHelper.getWritableDatabase());
  }
  
  protected void a(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(atnp.a(StoryEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(StoryVideoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(StoryVideoListEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(UserEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(PublishVideoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(ReportWatchVideoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(VideoCollectionEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(MemoryInfoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(StoryVideoSimpleInfoEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(TroopStoryEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(CardEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(TopicInfoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(UnionIdMapEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(ShareGroupListEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(DiscoverBannerVideoEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(MsgTabNodeEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(MsgTabHaloEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(MsgTabNodeVidListEntity.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(DownloadingUrlEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(StoryAlbumPicEntry.class.getSimpleName()));
    paramSQLiteDatabase.execSQL(atnp.a(StoryAlbumEntry.class.getSimpleName()));
  }
  
  public ajrl build(String paramString)
  {
    if (this.dbHelper == null)
    {
      this.mInnerDbHelper = new QQEntityManagerFactory.SQLiteOpenHelperImpl(this, "qqstory_" + paramString + ".db", null, 180);
      this.dbHelper = new ajrl(this.mInnerDbHelper);
    }
    return this.dbHelper;
  }
  
  public void createDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase)
  {
    paramSQLiteDatabase.execSQL(atnp.a(new UserEntry()));
    paramSQLiteDatabase.execSQL(atnp.a(new StoryEntry()));
    paramSQLiteDatabase.execSQL(atnp.a(new StoryVideoEntry()));
    paramSQLiteDatabase.execSQL(atnp.a(new StoryVideoListEntry()));
    paramSQLiteDatabase.execSQL(atnp.a(new PublishVideoEntry()));
    paramSQLiteDatabase.execSQL(atnp.a(new ReportWatchVideoEntry()));
    paramSQLiteDatabase.execSQL(atnp.a(new VideoCollectionEntry()));
    paramSQLiteDatabase.execSQL(atnp.a(new MemoryInfoEntry()));
    paramSQLiteDatabase.execSQL(atnp.a(new StoryVideoSimpleInfoEntity()));
    paramSQLiteDatabase.execSQL(atnp.a(new TroopStoryEntry()));
    paramSQLiteDatabase.execSQL(atnp.a(new CardEntry()));
    paramSQLiteDatabase.execSQL(atnp.a(new TopicInfoEntry()));
    paramSQLiteDatabase.execSQL(atnp.a(new UnionIdMapEntity()));
    paramSQLiteDatabase.execSQL(atnp.a(new ShareGroupListEntry()));
    paramSQLiteDatabase.execSQL(atnp.a(new DiscoverBannerVideoEntry()));
    paramSQLiteDatabase.execSQL(atnp.a(new MsgTabNodeEntity()));
    paramSQLiteDatabase.execSQL(atnp.a(new MsgTabHaloEntity()));
    paramSQLiteDatabase.execSQL(atnp.a(new MsgTabNodeVidListEntity()));
    paramSQLiteDatabase.execSQL(atnp.a(new DownloadingUrlEntry()));
    paramSQLiteDatabase.execSQL(atnp.a(new MsgTabNodeRecommendActivityReadEntity()));
    paramSQLiteDatabase.execSQL(atnp.a(new StoryAlbumPicEntry()));
    paramSQLiteDatabase.execSQL(atnp.a(new StoryAlbumEntry()));
  }
  
  public String getPackageName()
  {
    return getClass().getPackage().getName();
  }
  
  public void upgradeDatabase(android.database.sqlite.SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 > paramInt2)
    {
      a(paramSQLiteDatabase);
      createDatabase(paramSQLiteDatabase);
      urk.d("Q.qqstory.QQStoryEntityManagerFactory", "Version %d turn to %d ,clear all data", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      return;
    }
    if (paramInt1 < 29)
    {
      paramSQLiteDatabase.execSQL(atnp.a(PublishVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new PublishVideoEntry()));
    }
    if (paramInt1 < 70) {
      paramSQLiteDatabase.execSQL(atnp.a("FirstVideoEntry"));
    }
    if (paramInt1 < 90)
    {
      paramSQLiteDatabase.execSQL(atnp.a(TopicInfoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new TopicInfoEntry()));
    }
    if (paramInt1 < 98)
    {
      paramSQLiteDatabase.execSQL(atnp.a(LikeEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new LikeEntry()));
      paramSQLiteDatabase.execSQL(atnp.a(LiveVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new LiveVideoEntry()));
      paramSQLiteDatabase.execSQL(atnp.a(MemoryInfoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new MemoryInfoEntry()));
      paramSQLiteDatabase.execSQL(atnp.a(OfficialRecommendEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new OfficialRecommendEntry()));
      paramSQLiteDatabase.execSQL(atnp.a(ReportWatchVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new ReportWatchVideoEntry()));
      paramSQLiteDatabase.execSQL(atnp.a(UserEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new UserEntry()));
      paramSQLiteDatabase.execSQL(atnp.a(StoryEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new StoryEntry()));
      paramSQLiteDatabase.execSQL(atnp.a(StoryVideoListEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new StoryVideoListEntry()));
      paramSQLiteDatabase.execSQL(atnp.a(VideoCollectionEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new VideoCollectionEntry()));
      paramSQLiteDatabase.execSQL(atnp.a(UnionIdMapEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new UnionIdMapEntity()));
    }
    if (paramInt1 < 102)
    {
      paramSQLiteDatabase.execSQL(atnp.a(CommentEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new CommentEntry()));
      paramSQLiteDatabase.execSQL(atnp.a(TroopStoryEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new TroopStoryEntry()));
    }
    if (paramInt1 < 112)
    {
      paramSQLiteDatabase.execSQL(atnp.a(CardEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new CardEntry()));
    }
    if (paramInt1 < 134)
    {
      paramSQLiteDatabase.execSQL(atnp.a(FeedEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new FeedEntry()));
    }
    if (paramInt1 < 138)
    {
      paramSQLiteDatabase.execSQL(atnp.a(StoryVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new StoryVideoEntry()));
    }
    if (paramInt1 < 138)
    {
      paramSQLiteDatabase.execSQL(atnp.a(MemoryInfoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new MemoryInfoEntry()));
    }
    if (paramInt1 < 158)
    {
      paramSQLiteDatabase.execSQL(atnp.a(MsgTabNodeRecommendActivityReadEntity.TABLE_NAME));
      paramSQLiteDatabase.execSQL(atnp.a(new MsgTabNodeRecommendActivityReadEntity()));
      paramSQLiteDatabase.execSQL(atnp.a(MsgTabNodeEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new MsgTabNodeEntity()));
      paramSQLiteDatabase.execSQL(atnp.a(MsgTabNodeVidListEntity.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new MsgTabNodeVidListEntity()));
    }
    if (paramInt1 < 178)
    {
      paramSQLiteDatabase.execSQL(atnp.a(StoryVideoEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new StoryVideoEntry()));
      paramSQLiteDatabase.execSQL(atnp.a(StoryAlbumEntry.class.getSimpleName()));
      paramSQLiteDatabase.execSQL(atnp.a(new StoryAlbumEntry()));
    }
    a("com.tencent.biz.qqstory.database", paramSQLiteDatabase);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sow
 * JD-Core Version:    0.7.0.1
 */