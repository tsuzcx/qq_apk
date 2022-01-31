import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tbz
  implements tck
{
  private aukn a;
  
  private QQStoryContext a()
  {
    return QQStoryContext.a();
  }
  
  public static List<? extends aukm> a(aukn paramaukn, Class<? extends aukm> paramClass, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    return paramaukn.a(paramClass, paramString1, false, paramString2, paramArrayOfString, null, null, null, null, null);
  }
  
  public List<CommentEntry> a()
  {
    Object localObject = QQStoryContext.a().b();
    List localList = a(this.a, CommentEntry.class, CommentEntry.class.getSimpleName(), "status<>? and authorUnionId=?", new String[] { String.valueOf(0), localObject });
    localObject = localList;
    if (localList == null) {
      localObject = new ArrayList();
    }
    veg.a("Q.qqstory:CommentManager", "query fail comment's size = %d", Integer.valueOf(((List)localObject).size()));
    return localObject;
  }
  
  public List<CommentEntry> a(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 4;; i = 3)
    {
      List localList = a(this.a, CommentEntry.class, CommentEntry.class.getSimpleName(), "feedId=? and type=?", new String[] { paramString, String.valueOf(i) });
      Object localObject = localList;
      if (localList == null) {
        localObject = new ArrayList();
      }
      veg.a("Q.qqstory:CommentManager", "query comment feeds id %s, %d", paramString, Integer.valueOf(((List)localObject).size()));
      return localObject;
    }
  }
  
  public void a()
  {
    this.a = a().a().createEntityManager();
  }
  
  public void a(int paramInt)
  {
    Object localObject = a(this.a, CommentEntry.class, CommentEntry.class.getSimpleName(), "commentId=?", new String[] { String.valueOf(paramInt) });
    if (localObject == null) {}
    for (;;)
    {
      return;
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        CommentEntry localCommentEntry = (CommentEntry)((Iterator)localObject).next();
        localCommentEntry.setStatus(1001);
        this.a.b(localCommentEntry);
      }
    }
  }
  
  public void a(@NonNull CommentEntry paramCommentEntry)
  {
    paramCommentEntry.setStatus(1000);
    this.a.b(paramCommentEntry);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramInt <= 0))
    {
      veg.d("Q.qqstory:CommentManager", "push info invalidate feedId:%s, commentId:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
      return;
    }
    Object localObject1 = a(this.a, CommentEntry.class, CommentEntry.class.getSimpleName(), "feedId=? and commentId=?", new String[] { paramString, String.valueOf(paramInt) });
    int j;
    int i;
    Object localObject2;
    label123:
    int k;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      j = 0;
      i = 0;
      if (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CommentEntry)((Iterator)localObject1).next();
        if (((CommentEntry)localObject2).type == 3)
        {
          i = j;
          j = 1;
        }
        for (;;)
        {
          k = j;
          j = i;
          i = k;
          break;
          if (((CommentEntry)localObject2).type != 4) {
            break label366;
          }
          k = 1;
          j = i;
          i = k;
        }
      }
      k = j;
      j = i;
      i = k;
    }
    for (;;)
    {
      k = this.a.a(CommentEntry.class.getSimpleName(), "commentId=? and feedId=? and type in (?,?)", new String[] { String.valueOf(paramInt), paramString, String.valueOf(4), String.valueOf(3) });
      localObject1 = (uwa)tdc.a(11);
      localObject2 = (CommentLikeFeedItem)((uwa)localObject1).a(paramString);
      if (localObject2 == null) {
        break;
      }
      if (k > 0)
      {
        if (j != 0)
        {
          ((CommentLikeFeedItem)localObject2).mFriendCommentCount -= 1;
          if (((CommentLikeFeedItem)localObject2).mFriendCommentCount < 0) {
            ((CommentLikeFeedItem)localObject2).mFriendCommentCount = 0;
          }
        }
        if (i != 0)
        {
          ((CommentLikeFeedItem)localObject2).mFanCommentCount -= 1;
          if (((CommentLikeFeedItem)localObject2).mFanCommentCount < 0) {
            ((CommentLikeFeedItem)localObject2).mFanCommentCount = 0;
          }
        }
      }
      ((CommentLikeFeedItem)localObject2).mCommentCount -= 1;
      if (((CommentLikeFeedItem)localObject2).mCommentCount < 0) {
        ((CommentLikeFeedItem)localObject2).mCommentCount = 0;
      }
      ((uwa)localObject1).a((FeedItem)localObject2);
      paramString = new tah(4, paramString, 2, (CommentLikeFeedItem)localObject2);
      paramString.c = paramInt;
      ste.a().dispatch(paramString);
      return;
      label366:
      k = i;
      i = j;
      j = k;
      break label123;
      i = 0;
      j = 0;
    }
  }
  
  public void a(@NonNull List<CommentEntry> paramList, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (paramBoolean1) {
      i = 4;
    }
    aukn localaukn;
    Object localObject2;
    for (;;)
    {
      localaukn = a().a().createEntityManager();
      localaukn.a().a();
      if (!paramBoolean2) {
        break;
      }
      try
      {
        localObject1 = a(paramString, paramBoolean1);
        veg.a("Q.qqstory:CommentManager", "delete comment feeds id %s, %d", paramString, Integer.valueOf(((List)localObject1).size()));
        if (localObject1 == null) {
          break;
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (CommentEntry)((Iterator)localObject1).next();
          ((CommentEntry)localObject2).setStatus(1001);
          if (((CommentEntry)localObject2).status == 0) {
            localaukn.b((aukm)localObject2);
          }
        }
        i = 3;
      }
      finally
      {
        localaukn.a().b();
      }
    }
    Object localObject1 = a(this.a, CommentEntry.class, CommentEntry.class.getSimpleName(), "feedId=? and type=? and status<>? ", new String[] { paramString, String.valueOf(i), String.valueOf(0) });
    if (localObject1 != null) {}
    for (int j = ((List)localObject1).size();; j = 0)
    {
      veg.a("Q.qqstory:CommentManager", "fail comment size:%d for feedId:%s", Integer.valueOf(j), paramString);
      localObject2 = new ArrayList(j);
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        CommentEntry localCommentEntry = (CommentEntry)localIterator.next();
        localCommentEntry.feedId = paramString;
        localCommentEntry.type = i;
        localCommentEntry.setStatus(1000);
        localaukn.b(localCommentEntry);
        if (localObject1 != null)
        {
          j = ((List)localObject1).indexOf(localCommentEntry);
          if (j != -1) {
            ((List)localObject2).add(((List)localObject1).get(j));
          }
        }
      }
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext()) {
        localaukn.b((CommentEntry)((Iterator)localObject1).next());
      }
      veg.a("Q.qqstory:CommentManager", "insert comment feeds id %s, %d", paramString, Integer.valueOf(paramList.size()));
      localaukn.a().c();
      localaukn.a().b();
      return;
    }
  }
  
  public List<CommentEntry> b(String paramString, boolean paramBoolean)
  {
    paramString = a(paramString, paramBoolean);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramString.size())
    {
      CommentEntry localCommentEntry = (CommentEntry)paramString.get(i);
      if (localCommentEntry.status != 0)
      {
        localCommentEntry.status = 2;
        localArrayList.add(localCommentEntry);
      }
      i += 1;
    }
    return localArrayList;
  }
  
  public void b()
  {
    this.a.a();
  }
  
  public void b(@NonNull CommentEntry paramCommentEntry)
  {
    aukn localaukn = a().a().createEntityManager();
    localaukn.a().a();
    try
    {
      paramCommentEntry.type = 3;
      paramCommentEntry.setStatus(1000);
      localaukn.b(paramCommentEntry);
      CommentEntry localCommentEntry = new CommentEntry();
      localCommentEntry.copy(paramCommentEntry);
      localCommentEntry.type = 4;
      localCommentEntry.setStatus(1000);
      localaukn.b(localCommentEntry);
      localaukn.a().c();
      return;
    }
    finally
    {
      localaukn.a().b();
    }
  }
  
  public void c(@NonNull CommentEntry paramCommentEntry)
  {
    aukn localaukn = a().a().createEntityManager();
    localaukn.a().a();
    for (;;)
    {
      int i;
      try
      {
        List localList = a(this.a, CommentEntry.class, CommentEntry.class.getSimpleName(), "commentId=? and feedId=?", new String[] { String.valueOf(paramCommentEntry.commentId), paramCommentEntry.feedId });
        if (localList == null) {
          return;
        }
        i = 0;
        if (i < localList.size())
        {
          CommentEntry localCommentEntry = (CommentEntry)localList.get(i);
          if (localCommentEntry.type == 3)
          {
            localCommentEntry.copy(paramCommentEntry);
            localCommentEntry.type = 3;
            localaukn.a(localCommentEntry);
          }
          else if (localCommentEntry.type == 4)
          {
            localCommentEntry.copy(paramCommentEntry);
            localCommentEntry.type = 4;
            localaukn.a(localCommentEntry);
          }
        }
      }
      finally
      {
        localaukn.a().b();
      }
      localaukn.a().c();
      localaukn.a().b();
      return;
      i += 1;
    }
  }
  
  public void d(@NonNull CommentEntry paramCommentEntry)
  {
    paramCommentEntry.setStatus(1001);
    this.a.a(paramCommentEntry, "commentId=? and feedId=? and type in (?,?)", new String[] { String.valueOf(paramCommentEntry.commentId), paramCommentEntry.feedId, String.valueOf(4), String.valueOf(3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tbz
 * JD-Core Version:    0.7.0.1
 */