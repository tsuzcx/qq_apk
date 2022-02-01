package org.apache.commons.io.input;

import java.io.InputStream;

public class UnixLineEndingInputStream
  extends InputStream
{
  private final boolean ensureLineFeedAtEndOfFile;
  private boolean eofSeen = false;
  private boolean slashNSeen = false;
  private boolean slashRSeen = false;
  private final InputStream target;
  
  public UnixLineEndingInputStream(InputStream paramInputStream, boolean paramBoolean)
  {
    this.target = paramInputStream;
    this.ensureLineFeedAtEndOfFile = paramBoolean;
  }
  
  private int eofGame(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (!this.ensureLineFeedAtEndOfFile) {
        return -1;
      }
      if (!this.slashNSeen)
      {
        this.slashNSeen = true;
        return 10;
      }
    }
    return -1;
  }
  
  private int readWithUpdate()
  {
    int i = this.target.read();
    boolean bool2 = true;
    boolean bool1;
    if (i == -1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.eofSeen = bool1;
    if (this.eofSeen) {
      return i;
    }
    if (i == 10) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.slashNSeen = bool1;
    if (i == 13) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    this.slashRSeen = bool1;
    return i;
  }
  
  public void close()
  {
    super.close();
    this.target.close();
  }
  
  public void mark(int paramInt)
  {
    try
    {
      throw new UnsupportedOperationException("Mark notsupported");
    }
    finally {}
  }
  
  public int read()
  {
    boolean bool = this.slashRSeen;
    if (this.eofSeen) {
      return eofGame(bool);
    }
    int i = readWithUpdate();
    if (this.eofSeen) {
      return eofGame(bool);
    }
    if (this.slashRSeen) {
      return 10;
    }
    if ((bool) && (this.slashNSeen)) {
      return read();
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.apache.commons.io.input.UnixLineEndingInputStream
 * JD-Core Version:    0.7.0.1
 */